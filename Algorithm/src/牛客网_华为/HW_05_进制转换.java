package 牛客网_华为;

import java.util.Scanner;

public class HW_05_进制转换 {
    public static void main(String[] args) {


    }

    static void test1(){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            System.out.println(Integer.decode(str));
        }
    }

    static void test2(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            System.out.println(Integer.valueOf(str.substring(2),16).toString());
        }
    }

    static void test3() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String num = str.substring(2,str.length());
            int result = 0;
            int power = 1;
            for(int i = num.length() - 1; i >= 0; i--){
                char c = num.charAt(i);
                if(c >= '0' && c <= '9'){
                    result += (c - '0') * power;
                }else if (c >= 'A' && c <= 'F'){
                    result += (c - 'A' + 10) * power;
                }
                power *= 16;
            }
            System.out.println(result);
        }
        sc.close();
    }
}
