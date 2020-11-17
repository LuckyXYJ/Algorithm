package 牛客网_华为;

import java.util.*;

public class HW_40_统计字符包含字母_空格个数 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int isLetter=0,isDigit=0,isWhitespace=0,isQt=0;
            char[] str = sc.nextLine().toCharArray();
            for(int i=0;i<str.length;i++){
                char a = str[i];
                if(Character.isLetter(a))
                    isLetter++;
                else if(Character.isDigit(a))
                    isDigit++;
                else if(Character.isWhitespace(a))
                    isWhitespace++;
                else isQt++;
            }
            System.out.println(isLetter);
            System.out.println(isWhitespace);
            System.out.println(isDigit);
            System.out.println(isQt);
        }
    }
}
