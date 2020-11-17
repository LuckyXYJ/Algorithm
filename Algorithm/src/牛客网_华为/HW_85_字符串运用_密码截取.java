package 牛客网_华为;

import java.util.Scanner;
public class HW_85_字符串运用_密码截取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.next();
            System.out.println(HW_85_字符串运用_密码截取.getNumber(input));


        }
    }
    public static int getNumber(String str){
        int result = 1;
        //将字符串反转
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        //获取所有子串，查看翻转后的字符串是否包含该子串
        for(int i = temp.length(); i >= 1 ;i--){
            //i为子串的长度
            for(int j = 0; j <= temp.length()-i;j++){
                String tempSubString = temp.substring(j,j + i);
                if(str.contains(tempSubString)){
                    return i;
                }
            }
        }
        return result;
    }

}