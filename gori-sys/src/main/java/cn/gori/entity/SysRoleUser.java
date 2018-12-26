package cn.gori.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
public class SysRoleUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String roleId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysRoleUser{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
