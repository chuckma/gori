package cn.gori.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */

@Data
@ToString
@EqualsAndHashCode
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String pId;

    private String url;

    /**
     * 排序字段
     */
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

    private String createBy;

    private LocalDateTime createDate;

    private String updateBy;

    private LocalDateTime updateDate;

    /**
     * 权限
     */
    private String permission;

    /**
     * 1栏目2菜单
     */
    private Integer menuType;

    private int num;

    private List<SysRole> roleList;


    private List<SysMenu> children=new ArrayList<SysMenu>();

    public void addChild(SysMenu sysMenu){
        children.add(sysMenu);
    }

}
