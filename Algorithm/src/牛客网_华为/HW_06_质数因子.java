package 牛客网_华为;

import java.util.Scanner;

public class HW_06_质数因子 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long num = Long.parseLong(scan.next());
        test(num);
    }

    public static void getPrimer(long num){
        for (int i= 2;i <= num; i++){
            if (num % i==0){
                System.out.print(i + " ");
                getPrimer(num/i);
                break;
            }
            if (i==num){
                System.out.print( i + "");
            }
        }
    }

    static void test(long num) {
        for (int i = 2; i * i <= num ; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
                i = 1;
            }
        }
        System.out.print(num + " ");
    }
}
