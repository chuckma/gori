package cn.gori.service;

import cn.gori.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
public interface ISysUserService extends IService<SysUser> {

    public void setMenuAndRoles(String username);
}
