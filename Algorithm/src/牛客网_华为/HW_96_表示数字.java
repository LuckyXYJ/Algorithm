package 牛客网_华为;

import java.util.*;
public class HW_96_表示数字{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String ss = s.replaceAll("([\\d]+)","*$1*");
            System.out.println(ss);
        }
    }
}