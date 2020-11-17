package 牛客网_华为;

import java.util.Scanner;

import static javax.swing.UIManager.getString;

public class HW_11_数字颠倒 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        test1(number);
    }

    static void test1(int number) {
        StringBuilder s = new StringBuilder();
        while (number != 0) {
            s.append(number % 10);
            number /= 10;
        }
        System.out.println(s.toString());
    }
}
