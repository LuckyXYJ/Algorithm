package 牛客网_华为;

import java.util.*;

public class HW_82_将真分数分解为埃及分数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.next().split("/");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            StringBuffer sb = new StringBuffer();
            while (a != 1) {
                if (b % (a - 1) == 0) {
                    sb.append("1/" + b / (a - 1) + "+");
                    a = 1;
                } else {
                    int q = b / a; //求得 b/a 的商
                    int r = b - a * q; // 求得 b /a 的余数
                    sb.append("1/" + (q + 1) + "+");
                    a = a - r;
                    b = b * (q + 1);
                    if (b % a == 0) {
                        b = b / a;
                        a = 1;
                    }
                }
            }
            sb.append("1/" + b);
            System.out.println(sb);
        }
        sc.close();
    }
}