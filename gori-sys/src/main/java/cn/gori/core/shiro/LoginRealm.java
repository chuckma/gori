package cn.gori.core.shiro;

import cn.gori.base.CurrentMenu;
import cn.gori.base.CurrentRole;
import cn.gori.base.CurrentUser;
import cn.gori.entity.SysUser;
import cn.gori.service.ISysUserService;
import cn.gori.util.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhuxiaomeng
 * @date 2017/12/4.
 * @email 154040976@qq.com
 */
@Service
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService userService;


    /**
     * 获取授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String name = (String) principalCollection.getPrimaryPrincipal();
        Set<String> realmNames = principalCollection.getRealmNames();
        List<String> realmNameList = new ArrayList<>(realmNames);
        if ("BlogLogin".equals(realmNameList.get(0))) {
            String[] roles = JWTUtil.getRoles(name);
            assert roles != null;
            for (String role : roles) {
                info.addRole(role);
            }
        } else {
            //根据用户获取角色 根据角色获取所有按钮权限
            CurrentUser cUser = (CurrentUser) ShiroUtil.getSession().getAttribute("curentUser");
            for (CurrentRole cRole : cUser.getCurrentRoleList()) {
                info.addRole(cRole.getId());
            }
            for (CurrentMenu cMenu : cUser.getCurrentMenuList()) {
                if (!StringUtils.isEmpty(cMenu.getPermission())) {
                    info.addStringPermission(cMenu.getPermission());
                }
            }
        }

        return info;
    }

    /**
     * 获取认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        SysUser s = null;
        try {
//            s = userService.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (s == null) {
            throw new UnknownAccountException("账户密码不正确");
        }
        ByteSource byteSource = ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo(username, s.getPassword(), byteSource, getName());
    }
}
