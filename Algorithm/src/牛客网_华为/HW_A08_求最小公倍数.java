package 牛客网_华为;
import java.util.Scanner;

/**
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * 输入描述:
 * 输入两个正整数A和B。
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 5 7
 * 输出
 * 35
 */

public class HW_A08_求最小公倍数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int int1= scanner.nextInt();
        int int2= scanner.nextInt();
        System.out.println(int1*int2/methods(int1,int2));
    }
    public static int methods(int int1,int int2){
        if(int1 == int2){
            return int2;
        }
        if(int1 > int2){
            int differ= int1-int2;
            return methods(int2,differ);
        }else{
            int differ= int2-int1;
            return methods(int1,differ);
        }
    }
}

/*
辗转相除法
private int gcd(int a, int b) {
        if (b == 0) return a;
        return a % b == 0 ? b : gcd(b, a%b);
    }
    private int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a / gcd * b;
    }
    public Main() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int res = lcm(a, b);
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();
    }
* */
