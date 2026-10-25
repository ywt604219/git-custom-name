package com.itheima.domain;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCode());

    }
    public static String  getCode(){
        // 生成验证码长度是5，由四位大小写字母和1位数字组成同一个字母可以重复，数字可以出现在任意位置
        //1.把所有大小写字母都放到一个容器
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i <= 26; i++) {
            list.add((char)(i + 'a'));//强制转换
            list.add((char)(i + 'A'));
        }
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++){
            int index = r.nextInt(list.size());
            char c = list.get(index);//找到随机索引的字符
            //System.out.println(c);
            //还要拼接
            sb.append(c);
        }
        //生成一个随机数
        sb.append(r.nextInt(10));
        //数字的位置卡哇伊是任意的
        //先把sb变成字符串，调用tocharArray
        char[] chars = sb.toString().toCharArray();//sb.toString()调用的，变成了一个字符数组
        //把最大索引的数据和随机索引交换
        int index = r.nextInt(chars.length);
        char temp = chars[index];
        chars[index] = chars[chars.length - 1];//把最大索引的数据和随机索引交换
        chars[chars.length - 1] = temp;
        //把字符数组变成字符串
        String code = new String(chars);
        return code;




    }
}
