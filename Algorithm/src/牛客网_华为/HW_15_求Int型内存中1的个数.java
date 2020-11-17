package 牛客网_华为;

import java.util.Scanner;

public class HW_15_求Int型内存中1的个数 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=31;i>=0;i--){
            sb.append((num>>>i)&1);
        }
        String line=sb.toString();
        System.out.println(line.length()-line.replaceAll("1","").length());
    }
}
