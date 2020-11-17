package 牛客网_华为;

import java.util.*;

public class HW_79_计算字符串的相似度 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();

            // 求出两个字符串中较长的那个字符串长度
            int lenA = a.length();
            int lenB = b.length();

            int[][] dp = new int[lenA + 1][lenB + 1];

            // 初始化
            for (int i = 0; i <= lenB; i++) {
                dp[0][i] = i;
            }

            for (int i = 0; i <= lenA; i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i <= lenA; i++) {
                for (int j = 1; j <= lenB; j++) {
                    if (a.charAt(i-1) == b.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else{
                        dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]);
                        dp[i][j] = Math.min(dp[i-1][j-1] , dp[i][j]) + 1;
                    }
                }
            }

            int res = dp[lenA][lenB] + 1;
            System.out.println("1/"+ res);

        }

        scan.close();
    }

}