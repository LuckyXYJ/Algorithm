package 牛客网_华为;
import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 * @author Administrator
 *
 */
public class HW_59_输出字符串中第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            boolean flag = true;
            for(int i=0;i<s.length();i++){
                Character temp = s.charAt(i);
                if(s.lastIndexOf(temp.toString())==s.indexOf(temp.toString())&&flag){
                    System.out.println(temp.toString());
                    flag = false;
                }
            }
            if(flag){
                System.out.println(-1);
            }

        }
        sc.close();
    }
}

