package cn.gori.entity;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}