package 牛客网_华为;

import java.util.Scanner;

public class HW_04_字符串分割 {
    public static void main(String[] args) {
        test1();
    }

    static void test1(){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            StringBuilder stringBuilder = new StringBuilder();
            String str = scanner.nextLine();
            stringBuilder.append(str);
            int size = stringBuilder.length();
            int addZero = (8 - size%8)%8;
            while(addZero > 0){
                stringBuilder.append('0');
                addZero--;
            }
            String  str1 = stringBuilder.toString();
            while(str1.length()>0){
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }

        }
    }

    static void test2(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String next = sc.next();
            while (next.length()>8){
                String substring = next.substring(0, 8);
                System.out.println(substring);
                next = next.substring(8);
            }
            int tmp = 8 - next.length();
            for (int i = 0; i < tmp; i++) {
                next += "0";
            }
            System.out.println(next);

        }
    }

}
