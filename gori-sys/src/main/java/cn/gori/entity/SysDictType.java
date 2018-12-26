package cn.gori.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 字典主表
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
public class SysDictType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 编码
     */
    private String code;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 字典名称
     */
    private String text;

    private String createBy;

    private LocalDateTime createDate;

    private String updateBy;

    private LocalDateTime updateDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "SysDictType{" +
        "id=" + id +
        ", code=" + code +
        ", delFlag=" + delFlag +
        ", text=" + text +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        "}";
    }
}
