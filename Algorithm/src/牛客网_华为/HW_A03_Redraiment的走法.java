package 牛客网_华为;
import java.util.Scanner;


public class HW_A03_Redraiment的走法{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            //dp[i] 保留了从第一个到第i-1个庄子能走的最大步数
            for(int i = 0 ; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(a[j] < a[i]){
                        //最终dp[i]的值为其前面的最大的dp[j] + 1；
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
            }

            int max = 1;
            for(int i = 0; i < n; i++){
                if(dp[i] > max){
                    max = dp[i];
                }
            }

            System.out.println(max);

        }

        sc.close();
    }
}