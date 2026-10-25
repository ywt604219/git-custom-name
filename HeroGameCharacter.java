package com.itheima.domain;

import java.util.ArrayList;

public class HeroGameCharacter extends GameCharacter {
    public ArrayList<String> skillList;

    public HeroGameCharacter() {
        super();
        this.skillList = new ArrayList<>();//构造方法时顺手就创建了集合

    }

    public HeroGameCharacter(String name, int HP, int attack, int defense) {
        super(name, HP, attack, defense);
        skillList = new ArrayList<>();
    }
    public String showSkill() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skillList.size(); i++)
            sb.append(skillList.get(i)).append(" ");
        return sb.toString();
    }




}
