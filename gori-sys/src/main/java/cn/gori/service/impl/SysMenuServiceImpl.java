package cn.gori.service.impl;

import cn.gori.entity.SysMenu;
import cn.gori.mapper.SysMenuMapper;
import cn.gori.service.ISysMenuService;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuDao;

    @Override
    public List<SysMenu> getMenuChildren(String id) {
        return menuDao.getMenuChildren(id);
    }

    @Override
    public List<SysMenu> getUserMenu(String id) {
        return menuDao.getUserMenu(id);
    }

    @Override
    public JSONArray getMenuJsonByUser(List<SysMenu> menuList) {
        JSONArray jsonArr = new JSONArray();
        Collections.sort(menuList, (o1, o2) -> {
            if (o1.getOrderNum() == null || o2.getOrderNum() == null) {
                return -1;
            }
            if (o1.getOrderNum() > o2.getOrderNum()) {
                return 1;
            }
            if (o1.getOrderNum().equals(o2.getOrderNum())) {
                return 0;
            }
            return -1;
        });
        int pNum = 1000;
        for (SysMenu menu : menuList) {
            if (StringUtils.isEmpty(menu.getPId())) {
                SysMenu sysMenu = getChilds(menu, pNum, 0, menuList);
                jsonArr.add(sysMenu);
                pNum += 1000;
            }
        }
        return jsonArr;
    }

    public SysMenu getChilds(SysMenu menu, int pNum, int num, List<SysMenu> menuList) {
        for (SysMenu menus : menuList) {
            if (menu.getId().equals(menus.getPId()) && menus.getMenuType() == 0) {
                ++num;
                SysMenu m = getChilds(menus, pNum, num, menuList);
                m.setNum(pNum + num);
                menu.addChild(m);
            }
        }
        return menu;

    }
}
