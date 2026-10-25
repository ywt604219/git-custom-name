package com.itheima.domain;

public class GameCharacter {
    public String name;
    public int HP;
    public int attack;
    public int defense;
    public int maxHP;

    public GameCharacter() {
    }

    public GameCharacter(String name, int HP, int attack, int defense) {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.maxHP = HP;//初始血量是最大初始血量
    }
    //属性
    //行为
    //判断人物是否存活
    public boolean isAlive() {
        return HP > 0;
    }
    //回复血量
    //形参：具体的回血量
    public void heal(int amount){
        HP += amount;
        if (HP > maxHP) {
            HP = maxHP;
        }
    }
    //3.回合制，收到伤害
    public void takeDamage(int damage) {
        HP -= damage;
        if (HP < 0) {
            HP = 0;
        }
    }
    //4.展示人物属性
    public void show() {
        System.out.println(name+"的当前生命为：" + HP + " 攻击力：" + attack + " 防御力：" + defense);
    }


}
