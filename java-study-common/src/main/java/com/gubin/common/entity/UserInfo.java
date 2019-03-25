package com.gubin.common.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity@Table(name="user_info")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "realname")
    private String realname;

    @Column(name = "address")
    private String address;

    @Column(name = "id_number")
    private String id_number;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "qq")
    private String qq;

    @Column(name = "weixin")
    private String weixin;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account=account;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getRealname(){
        return realname;
    }

    public void setRealname(String realname){
        this.realname=realname;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getId_number(){
        return id_number;
    }

    public void setId_number(String id_number){
        this.id_number=id_number;
    }

    public Integer getSex(){
        return sex;
    }

    public void setSex(Integer sex){
        this.sex=sex;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getQq(){
        return qq;
    }

    public void setQq(String qq){
        this.qq=qq;
    }

    public String getWeixin(){
        return weixin;
    }

    public void setWeixin(String weixin){
        this.weixin=weixin;
    }

}