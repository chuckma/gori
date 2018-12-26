package cn.gori.service;

import cn.gori.entity.SysMenu;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getMenuChildren(String id);

    List<SysMenu> getUserMenu(String id);

    public JSONArray getMenuJsonByUser(List<SysMenu> menuList);

}
