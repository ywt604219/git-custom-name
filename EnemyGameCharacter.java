package com.itheima.domain;

public class EnemyGameCharacter extends GameCharacter {
    String skill;//技能只有一个所以用变量表示
    boolean defending;//判断当前人物是否拥有减伤效果

    public EnemyGameCharacter() {
        super();
    }

    public EnemyGameCharacter(String name, int HP, int attack, int defense, String skill) {
        super(name, HP, attack, defense);
        this.skill = skill;
    }
    //敌人需要重写受到伤害的方法
    //伤害等于攻击力*n%减去防御力，最小伤害为1


    @Override
    public void takeDamage(int damage) {
        if (defending) {
            damage = damage / 2 > 1 ? damage / 2 : 1;//否则1
            defending = false;//减伤效果只持续一回合
        }
        super.takeDamage(damage);//调用父类的方法
    }
}
