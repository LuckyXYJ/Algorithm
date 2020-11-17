package 牛客网_华为;

import java.util.Scanner;
/**
 * Created by lxb on 16/8/3.
 */
public class HW_74_参数解析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int len = 0;
        int quotaNum = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '\"'){ quotaNum++; continue;
            }
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            } else if (quotaNum % 2 == 0){ sb.append('\n');
                len++;
            }else {
                sb.append(' ');
            }
        }
        System.out.println(len+1);
        System.out.println(sb.toString());

    }
}
