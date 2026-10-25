package com.itheima.ui;

import com.itheima.domain.EnemyGameCharacter;
import com.itheima.domain.HeroGameCharacter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FightingGame {
    public void gameStart(String username){
        System.out.println();
        System.out.println("游戏开始，"+username+"!");
        System.out.println();
        //创建玩家角色
        HeroGameCharacter player = createPlayerCharacter(username);
        //显示玩家角色信息
        System.out.println("玩家角色创建成功！");
        player.show();
        System.out.println();
        System.out.println("玩家的技能有："+player.showSkill());
        //创建多个敌人列表
        ArrayList<EnemyGameCharacter> enemyList = new ArrayList<>();
        enemyList.add(new EnemyGameCharacter("小白",80,10,10,"普通攻击"));
        enemyList.add(new EnemyGameCharacter("恶灵",100,20,5,"地狱之火"));
        enemyList.add(new EnemyGameCharacter("小乔妹妹",90,30,15,"星华缭乱"));
        enemyList.add(new EnemyGameCharacter("妲己大王",80,25,20,"女王崇拜"));




        int count = 1;//记录和第几个敌人战斗
        int wins = 0;//记录胜利的敌人数量
        while (player.isAlive()){
            if (wins!=0){
                //获取每一个敌人的信息进行属性点增加
                for (int i = 0; i < enemyList.size(); i++) {
                    EnemyGameCharacter c = enemyList.get(i);
                    //每场最大生命值+10
                    c.maxHP += 10;
                    c.HP = c.maxHP;
                    c.attack += 3;
                    c.defense += 3;
                    //每场战斗之前减伤buff清空
                    c.defense = 0;
                }

            }
            Random r = new Random();
            int index = r.nextInt(enemyList.size());
            EnemyGameCharacter enemy = enemyList.get(index);
            enemy.show();//显示敌人信息
        }



    }
    //属性分配
    //参数：用户名
    //返回值：创建好的玩家角色

    public HeroGameCharacter createPlayerCharacter(String username){
        System.out.println("正在创建玩家角色...");
        System.out.println("角色名为："+username);
        //属性分配
        //键盘录入
        int points = 20;
        System.out.println("请分配属性，共20点");
        Scanner sc = new Scanner(System.in);
        //定义数组把要提示的语句存起来
        String[] attributes = {"生命值（每点加10HP）：","攻击力（每点加2ATK）：","防御力（每点加1DEF）："};
        //定义数组记录三个属性分配的属性点
        int[] values = new int[3];
        //循环分配属性
        for (int i = 0; i < attributes.length; i++) {
            System.out.println(attributes[i]);
            int value = sc.nextInt();
            if (value<0){
                System.out.println("输入有误，默认分配0点");
                value = 0;
            }
            if (value>points){
                System.out.println("输入有误，默认分配最大剩余属性点");
                value = points;
            }
            points -= value;
            values[i] = value;
            System.out.println("剩余属性点："+points);
        }
        //直接创建玩家角色的对象
        HeroGameCharacter player = new HeroGameCharacter(username,values[0]*10+100,values[1]*2+10,values[2]);
        //添加玩家的技能
        player.skillList.add("普通攻击");
        player.skillList.add("强力一击");
        player.skillList.add("生命回复");
        return player;
    }


}
