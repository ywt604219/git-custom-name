package com.itheima.ui;

import com.itheima.domain.user;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Login {
    public void start() {
        //创建集合
        ArrayList<user> list = new ArrayList<>();//不能写在集合里面，注册和登录就在两个集合里面了


        while (true) {
            System.out.println("Starting the program...");
            System.out.println("欢迎来到文字格斗游戏");
            System.out.println("请选择操作：1.登录 2.注册 3.退出");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            //c+alt+t选择对应语句包裹代码

            switch (choice) {
                case "1":
                    login(list);//键盘录入信息，到下面的容器中判断，是否存在当前的用户名和密码，
                    break;//加入集合，确保操作的是同一个集合
                case "2":
                    register(list);//录入容器
                    break;
                case "3":
                    //System.out.println("退出");//直接让停止虚拟机运行
                    System.out.println("退出程序");
                    System.exit(0);

                    break;
                default:
                    System.out.println("无效的选择，请重新操作");
                    break;//需要用循环包裹
            }
        }

    }

    //先写注册，容器集合
    public void register(ArrayList<user> list) {
        //方法里面也要加集合
        //注册
        //键盘录入用户名密码到user的对象，在弄到集合里面
        //1.创建user对象
        user u = new user();
        //2.键盘录入用户名，校验是否符合要求，调用u.setUsername
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String username = sc.nextLine();
            //用户名校验。需要唯一，长度在3-16之间，只能由字母和数字组成，不可以纯数字
            //唯一，长度，内容
            //在开发中，先验证格式是否正确（本地），再验证唯一性（数据库）联网
            //判断数据判错不错剩下来的就是好的数据

            //长度
            //不要一直用if
            /*if (username.length() < 3 || username.length() > 16) {
                System.out.println("用户名长度不符合要求，请重新输入");
                continue;
            }*/ //写一个方法
            if (!checkLen(3, 16, username)) {//取反，如果不满足就提示
                System.out.println("用户名长度不符合要求，请重新输入");
                continue;
            }

            //内容，再定义方法
            if (!checkContent(username)) {//传递用户名
                System.out.println("用户名内容只能由字母和数字组成且不能是纯数字，请重新输入");
                continue;
            }
            //唯一
            if (contains(list, username)) {
                System.out.println("用户名已存在，请重新输入");
                continue;
            }
            u.setUsername(username);//设置用户名
            break;
        }
        //3.键盘录入密码，校验是否符合要求，调用u.setPassword
        while (true) {
            System.out.println("请输入密码：");
            String password1 = sc.nextLine();
            System.out.println("请再次输入密码：");
            String password2 = sc.nextLine();
            //   密码校验。长度在3-8之间，两次输入的密码一致
            if (!checkLen(3, 8, password1)) {
                System.out.println("密码长度不符合要求，需要3-8位之间，请重新输入");
                continue;
            }
            //两次输入是不是一样的
            if (!password1.equals(password2)) {
                System.out.println("两次输入的密码不一致，请重新输入");
                continue;
            }
            //密码只能是字母加数字，但是和用户名规则有区别，不可以是纯数字
            if (!checkPassword(password1)) {
                System.out.println("密码内容只能由字母和数字组成且不能是纯数字，请重新输入");
                continue;
            }
            u.setPassword(password1);
            break;
        }

        //4.把user对象添加到集合里面
        list.add(u);

        //5.提示成功
        System.out.println("注册成功");


    }
    public boolean checkLen(int minLen,int maxLen,String str) {
        if (str.length() < minLen || str.length() > maxLen) {
            return false;
        }else{
            return true;
        }
        //return str.length() >= minLen && str.length() <= maxLen;返回值本来就是boolean类型
    }//长度

    public boolean checkContent(String username) {//调用统计并返回
        int[] counts = getCount(username);
        //0索引是字母，1索引是数字，2索引是其他
        if (counts[0] > 0 && counts[1] >= 0 && counts[2] == 0) {
            return true;
        } else {
            return false;
        }
    }//内容
    public boolean checkPassword(String password) {//调用统计并返回
        int[] counts = getCount(password);
        //0索引是字母，1索引是数字，2索引是其他
        return counts[0] > 0 && counts[1] > 0 && counts[2] == 0;
    }
    public int[] getCount(String userInfo){//统计字符数量
        int charcount = 0;
        int numcount = 0;
        int othercount = 0;
        for (int i = 0; i < userInfo.length(); i++) {
            char c = userInfo.charAt(i);
            if (Character.isLetter(c)) {
                charcount++;
            } else if (Character.isDigit(c)) {
                numcount++;
            } else {
                othercount++;
            }
        }
        //需要返回3个结果
        //可以返回长度为3的数组
        return new int[]{charcount, numcount, othercount};
    }



    public boolean contains(ArrayList<user> list,String username) {
        for (int i = 0; i < list.size(); i++) {
            user u = list.get(i);//获取集合中的user对象
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }//唯一
    public void login(ArrayList<user> list) {
        System.out.println("登录");
        //1.判断用户名是否存在
        //2.判断是否被禁用
        //3.验证码
        //4.验证密码是否正确，三次

        //先去验证不合理的
        //1.键盘录入用户名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        boolean contains = contains(list, username);
        //2.判断
        if (!contains) {
           System.out.println("用户名不存在，请重新输入");
           return;
        }//如果不存在直接回到选择页面，滚去注册
        //3.状态
        int index = findIndex(list, username);
        user u = list.get(index);
        if (!u.isStatus()) {
            System.out.println("账号已禁用，请联系管理员");
            return;//回到选择界面重新注册
        }
        //4.键盘录入验证码和密码

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            //验证码也要在循环里面，这样每次输密码都会有验证码验证环节
            while (true) {
                //生成一个验证码
                String rightcode = getCode();
                System.out.println("请输入验证码：" + rightcode);
                String code = sc.nextLine();
                if (!code.equals(rightcode)) {
                    System.out.println("验证码错误，请重新输入");
                    continue;//验证码错误，回到验证码输入页面
                }else{
                    System.out.println("验证码正确");
                    break;//验证码正确，跳出循环,判断密码
                }
            }
            if (u.getPassword().equals(password)) {
                System.out.println("登录成功，游戏启动");
                FightingGame fg = new FightingGame();
                fg.gameStart(username);

                break;
            } else {
                System.out.println("密码错误，请重新输入");
                if (i == 2) {
                    System.out.println("密码错误次数过多，账号已禁用");
                    u.setStatus(false);//禁用账号
                    return;//回到选择界面重新注册
                }else{
                    System.out.println("密码错误，还有" + (2 - i) + "次机会，请重新输入");
                }
            }

        }


    }
    public int findIndex(ArrayList<user> list,String username){//返回要找的的东西的索引
        //先拿整体的对象
        for (int i = 0; i < list.size(); i++) {
            user u = list.get(i);//获取集合中的user对象
            if (u.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;

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




    }//获取验证码

    //战斗
    //1，角色创建，我和多个敌人
    //2.属性分配
    //3.回合制战斗系统
    //4.打一下，判断敌人生命值是否为0
    //5.敌人打我，判断我方生命值是否死亡
    //6.循环
    //普通攻击，技能攻击
    //胜场累积和成长系统（道具）（属性点）
    //生命：最大生命和实际生命
    //我方角色：name,HP,maxHP,attack,defense,skill
    //敌方角色：name,HP,maxHP,attack,defense,skill,defanding(buff)





}
