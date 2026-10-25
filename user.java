package com.itheima.domain;

import java.util.Random;

public class user {
    //属性
    private String username;
    private String id;
    private String password;
    private boolean status;//状态，有没有被禁用

    //id用户没办法设置，是自动生成的，格式为heima和为5位数字的随机数
    //生成id的方法
    public String creatId() {
        StringBuilder sb = new StringBuilder("heima");
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int num = r.nextInt(10);
            sb.append(num);
        }
        return sb.toString();//变回字符串

    }
    public user() {//空参
        //调用方法，设置id
        id = creatId();
        //修改Status的默认值
        this.status = true;
    }


    public user(String username, String password) {//别的形参不需要了
        this.username = username;
        this.id = creatId();
        this.password = password;
        this.status = true;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
