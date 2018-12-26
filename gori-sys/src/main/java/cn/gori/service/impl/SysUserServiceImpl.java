package cn.gori.service.impl;

import cn.gori.base.CurrentMenu;
import cn.gori.base.CurrentRole;
import cn.gori.base.CurrentUser;
import cn.gori.core.shiro.ShiroUtil;
import cn.gori.entity.SysMenu;
import cn.gori.entity.SysRole;
import cn.gori.entity.SysUser;
import cn.gori.mapper.SysUserMapper;
import cn.gori.service.ISysMenuService;
import cn.gori.service.ISysUserService;
import cn.gori.util.BeanUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    ISysMenuService menuService;

    @Autowired
    private SysUserMapper userMapper;
    @Override
    public void setMenuAndRoles(String username) {
        SysUser s = new SysUser();
        s.setUsername(username);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        s = userMapper.selectOne(wrapper);
        CurrentUser currentUser = new CurrentUser(s.getId(), s.getUsername(), s.getAge(), s.getEmail(), s.getPhoto(), s.getRealName());
        Subject subject = ShiroUtil.getSubject();
        /*角色权限封装进去*/
        //根据用户获取菜单
        Session session = subject.getSession();

        List<SysMenu> menuList = menuService.getUserMenu(s.getId());
        JSONArray json = menuService.getMenuJsonByUser(menuList);
        session.setAttribute("menu", json);


        List<CurrentMenu> currentMenuList = new ArrayList<>();
        List<SysRole> roleList = new ArrayList<>();
        for (SysMenu m : menuList) {
            CurrentMenu currentMenu = new CurrentMenu();
            BeanUtil.copyNotNullBean(m, currentMenu);
            currentMenuList.add(currentMenu);
            roleList.addAll(m.getRoleList());
        }

        roleList = new ArrayList<>(new HashSet<>(roleList));
        List<CurrentRole> currentRoleList = new ArrayList<>();

        for (SysRole r : roleList) {
            CurrentRole role = new CurrentRole();
            BeanUtil.copyNotNullBean(r, role);
            currentRoleList.add(role);
        }
        currentUser.setCurrentRoleList(currentRoleList);
        currentUser.setCurrentMenuList(currentMenuList);
        session.setAttribute("curentUser", currentUser);
    }
}
