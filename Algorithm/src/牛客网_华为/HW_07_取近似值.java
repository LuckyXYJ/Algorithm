package 牛客网_华为;

import java.util.Scanner;

public class HW_07_取近似值 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        System.out.println((int)(number + 0.5));
    }
}
