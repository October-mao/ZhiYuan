package com.mno.model;


/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mao
 * @create 2020-01-03
 * @since 1.0.0
 */
public class Speciality {
    private Integer id;
    private Integer userId;
    private String name;
    private Integer total;

    public Speciality( Integer userId, String name, Integer total) {
        this.userId = userId;
        this.name = name;
        this.total = total;
    }

    public Speciality() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
