package cn.gori.mapper;

import cn.gori.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenuChildren(String id);

    /**
     * 根据用户获取所有菜单
     * @param id
     * @return
     */
    List<SysMenu> getUserMenu(@Param("id") String id);
}
