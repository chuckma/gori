package cn.gori.controller;

import cn.gori.core.annotation.Log;
import cn.gori.core.shiro.ShiroUtil;
import cn.gori.entity.SysMenu;
import cn.gori.entity.SysUser;
import cn.gori.service.ISysLogService;
import cn.gori.service.ISysMenuService;
import cn.gori.service.ISysUserService;
import cn.gori.util.CustomUsernamePasswordToken;
import cn.gori.util.VerifyCodeUtils;
import com.alibaba.fastjson.JSONArray;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */

@Controller
@Slf4j
public class LoginController {


    @Autowired
    private ISysMenuService iSysMenuService;

    @Autowired
    private ISysUserService iSysUserService;


    @GetMapping(value = "login")
    public String loginCheck() {
        Subject subject = SecurityUtils.getSubject();
        Boolean rember = subject.isRemembered();
        boolean flag = subject.isAuthenticated() || rember;
        if (flag) {
            return "main/main";
        }
        return "login";
    }


    @PostMapping(value = "login")
    public String login(SysUser user, Model model, String rememberMe, HttpServletRequest request) {
        String codeMsg = (String) request.getAttribute("shiroLoginFailure");
        /* if ("code.error".equals(codeMsg)) {
            model.addAttribute("message", "验证码错误");
            return "/login";
        }*/

        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken(user.getUsername().trim(), user.getPassword(), "UserLogin");
        Subject subject = ShiroUtil.getSubject();
        String msg = null;

        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                iSysUserService.setMenuAndRoles(token.getUsername());
                token.getUsername();
                return "redirect:/main";
            }
        }catch (UnknownAccountException | IncorrectCredentialsException e) {
            msg = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败多次，账户锁定10分钟";
        }
        if (msg != null) {
            model.addAttribute("message", msg);
        }
        return "/login";
    }


    @GetMapping("/main")
    public String main() {
        return "main/main";
    }

    @Log(desc = "用户退出平台")
    @GetMapping(value = "/logout")
    public String logout() {
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
        return "/login";
    }


    /**
     * 组装菜单json格式
     * update by 17/12/13
     *
     * @return
     */
    public JSONArray getMenuJson() {
        List<SysMenu> mList = iSysMenuService.list();
        JSONArray jsonArr = new JSONArray();
        for (SysMenu sysMenu : mList) {
            SysMenu menu = getChild(sysMenu.getId());
            jsonArr.add(menu);
        }
        return jsonArr;
    }

    public SysMenu getChild(String id) {
        SysMenu sysMenu = iSysMenuService.getById(id);
        List<SysMenu> mList = iSysMenuService.getMenuChildren(id);
        for (SysMenu menu : mList) {
            SysMenu m = getChild(menu.getId());
            sysMenu.addChild(m);
        }
        return sysMenu;
    }


    @GetMapping(value = "/getCode")
    public void getYzm(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpg");

            //生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            log.info("verifyCode:{}", verifyCode);
            //存入会话session
            HttpSession session = request.getSession(true);
            session.setAttribute("_code", verifyCode.toLowerCase());
            //生成图片
            int w = 146, h = 33;
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
