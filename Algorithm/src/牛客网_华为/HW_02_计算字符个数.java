package 牛客网_华为;

import java.util.Scanner;

public class HW_02_计算字符个数 {

    public static void main(String[] args){

        test2();
    }

    static void test1(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        Character c =  scanner.nextLine().charAt(0);
        Character.toLowerCase(c);

        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(c == str.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    static void test2(){
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase();
        char s = sc.nextLine().charAt(0);
        System.out.print(str.length()-str.replaceAll(String.valueOf(s),"").length());
    }
}
