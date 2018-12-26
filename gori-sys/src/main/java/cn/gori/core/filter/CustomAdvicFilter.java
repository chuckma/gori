package cn.gori.core.filter;

import cn.gori.service.ISysMenuService;
import cn.gori.service.ISysUserService;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author zhuxiaomeng
 * @date 2017/12/13.
 * @email 154040976@qq.com
 * 自定义拦截器 暂时不用
 */
public class CustomAdvicFilter extends FormAuthenticationFilter {

  @Autowired
  private ISysUserService userService;

  @Autowired
  private ISysMenuService menuService;


  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
      return true;
  }
}
