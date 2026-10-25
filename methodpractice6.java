package method;

import java.util.Random;
import java.util.Scanner;

import static method.MethodDemo2.contains;

public class methodpractice6 {
    public static void main(String[] args) {
        //大乐透
        //从1-35中随机取5个不重复的数，从1-12中随机取2个不重复的数
        //同一注里，号码不能重复。
        //不同注之间，号码可以重复。
        //一等奖：中 5+2
        //二等奖：中 5+1
        //三等奖：中 5+0 或 4+2
        //四等奖：中 4+1
        //五等奖：中 4+0 或 3+2
        //六等奖：中 3+1 或 2+2
        //七等奖：中 3+0、2+1、1+2 或 0+2
        //利用random方法，生成随机彩票号码
        //键盘录入，模拟买彩票
        //是否中奖

        //1.生成彩票号码
        int[] lotteryNumber = createLotteryNumber();
        //printArray(lotteryNumber);
        //printArray(lotteryNumber);
        //2.scanner
        //buyLotteryNumber();
        int[] buyNumber = buyLotteryNumber();
        printArray(buyNumber);
        //3.判断是否中奖
        //3.1红区
        //3.2蓝区
        getWinnerNumber(lotteryNumber, buyNumber);






    }
    public static int [] buyLotteryNumber() {
        int[] buyNumber = new int[7];
        Scanner scanner = new Scanner(System.in);

        //前5个
        for (int i = 0; i < 5; ) {
            System.out.println("请输入第" + (i + 1) + "个号码：");
            int number = scanner.nextInt();
            //先判断范围
            if (number < 1 || number > 35) {
                //把两个判断拆开
                System.out.println("输入的号码范围错误，请重新输入");

                continue;
            }
            //判断是否唯一
            boolean isUnique = contains(buyNumber, 0, 4, number);
            //默认isUnique为true，如果在数组中存在该号码，则isUnique为false
            if (!isUnique) {
                System.out.println("输入的号码已存在，请重新输入");

                continue;
            }
            //如果代码执行到这里，说明输入的号码是合法的

            buyNumber[i] = number;
            i++;
        }

        //后2个
        for (int i = 0; i < 2; ) {
            System.out.println("请输入第" + (i + 6) + "个号码：");
            int number = scanner.nextInt();
            //先判断范围
            if (number < 1 || number > 12) {
                //把两个判断拆开
                System.out.println("输入的号码范围错误，请重新输入");
                continue;

            }

            boolean isUnique = contains(buyNumber, 5, 6, number);
            //数组是买号码，从5开始，到6结束
            if (!isUnique) {
                System.out.println("输入的号码已存在，请重新输入");
                continue;

            }
            //如果代码执行到这里，说明输入的号码是合法的

            buyNumber[i + 5] = number;
            i++;
        }

        return buyNumber;

    }//买彩票号码
   public static int[] createLotteryNumber() {
        //创建数组
        int[] lotteryNumber = new int[7];
        //随机生成号码
        Random random = new Random();
        for (int i = 0; i < 5; ) {
            //不把i++写在里面，只有true才可以加
            int number = random.nextInt(1, 36);
            boolean isUnique = contains(lotteryNumber, 0, 4, number);
            if (isUnique) {
                lotteryNumber[i] = number;
                i++;
            }

        }
       for (int i = 0; i < 2; ) {
           int number = random.nextInt(1, 13);
           //boolean isUnique = contains(lotteryNumber, number);不可以这样，跨区可以重复,修改contains方法
           boolean isUnique = contains(lotteryNumber, 5, 6, number);
           if (isUnique) {
               lotteryNumber[i + 5] = number;
               i++;
           }
       }

       return lotteryNumber;
    }//生成彩票号码
    public static boolean contains(int[] lotteryNumber,int start ,int end ,int number) {
    //只和指定范围的元素进行比较
        for (int i = start; i <= end; i++) {
            if (lotteryNumber[i] == number) {
                return false;
            }

        }
        return true;

    }    //contains方法,判断是否唯一
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "，");
        }
        System.out.print("]");
        System.out.println();
    }//printArray方法
    public static void getWinnerNumber(int[]arr1,int[]arr2) {
        //导入两个数组的数据，判断arr2在arr1中出现的次数
        //int count1 = 0;
        //计数器记录有多少个匹配的号码

        //判断需要分开前区和后区
        /*for (int i = 0; i < 5; i++) {
            //con+p,快速召唤contains的形参
            boolean isContained = contains(arr1, 0, 4, arr2[i]);
            //默认isContained为true，如果在数组中存在该号码，则isContained为false
            if (!isContained) {
                count1++;
            }
        }
        System.out.println("红区中了" + count1 + "个");

        int count2 = 0;
        for (int i = 0; i < 2; i++) {
            boolean isContained = contains(arr1, 5, 6, arr2[i]);
            if (!isContained) {
                count2++;
            }
        }
        System.out.println("蓝区中了" + count2 + "个");*/

        int count1 = getWinnerNumber(arr1, arr2, 0, 4);
        int count2 = getWinnerNumber(arr1, arr2, 5, 6);
        System.out.println("红区中了" + count1 + "个");
        System.out.println("蓝区中了" + count2 + "个");

        //根据中奖个数，判断中奖情况
        //alt+p,ai强制生成代码
        if (count1 == 5 && count2 == 2) {
            System.out.println("一等奖");
        } else if (count1 == 5 && count2 == 1) {
            System.out.println("二等奖");
        } else if (count1 == 5 && count2 == 0 || count1 == 4 && count2 == 2) {
            System.out.println("三等奖");
        } else if (count1 == 4 && count2 == 1) {
            System.out.println("四等奖");
        } else if (count1 == 4 && count2 == 0 || count1 == 3 && count2 == 2) {
            System.out.println("五等奖");
        } else if (count1 == 3 && count2 == 1 || count1 == 2 && count2 == 2) {
            System.out.println("六等奖");
        } else if (count1 == 3 && count2 == 0 || count1 == 2 && count2 == 1 || count1 == 1 && count2 == 2 || count1 == 0 && count2 == 2) {
            System.out.println("七等奖");
        }else {
            System.out.println("没有中奖");
        }


    }//观察到代码一样，重新写一个方法
    public static int getWinnerNumber(int[]arr1,int[]arr2,int start,int end) {//判断中了几个
        //导入两个数组的数据，判断arr2在arr1中出
        int count = 0;
        //计数器记录有多少个匹配的号码
        for (int i = start; i <= end; i++) {
            boolean isContained = contains(arr1, start, end, arr2[i]);
            if (!isContained) {
                count++;
            }
        }
        return count;
    }


}
