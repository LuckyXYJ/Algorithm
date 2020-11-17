package 牛客网_华为;

import java.util.*;
public class HW_78_超长正整数相加 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            boolean flag = false; //进位标志,只有加法，所以进位就必然是1
            StringBuffer sb = new StringBuffer();
            if(str1.length()>str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            for(int i=1; i<=str1.length(); i++) {
                int str1v = Integer.valueOf(String.valueOf(str1.charAt(str1.length()-i)));
                int str2v = Integer.valueOf(String.valueOf(str2.charAt(str2.length()-i)));
                int sum = str1v + str2v;
                if(flag) {//如果有进位，则当前位进位，然后置标志位false
                    sum++;
                    flag  = false;
                }
                if(sum>9) {
                    flag = true;
                }
                sb.append(sum%10);
            }
            for(int i=str2.length()-str1.length()-1; i>=0; i--) {
                int str2v = Integer.valueOf(String.valueOf(str2.charAt(i)));
                if(flag) {//如果有进位，则当前位进位，然后置标志位false
                    str2v++;
                    flag  = false;
                }
                if(str2v>9) {
                    flag = true;
                }
                sb.append(str2v%10);
            }
            if(flag) {
                sb.append(1);
            }
            System.out.println(sb.reverse().toString());
        }
    }
}