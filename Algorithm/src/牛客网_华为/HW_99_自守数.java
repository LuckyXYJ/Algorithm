package 牛客网_华为;

import java.util.Scanner;

public class HW_99_自守数{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int five_end = 5;
            int one_end = 1;
            int six_end = 6;
            int zero_end = 0;
            int count = 0;
            if(n == 0){
                System.out.println(1);
            }else if(n == 1){
                System.out.println(2);
            }
            for(int i = 6; i < n; i += 10){
                if(judge(zero_end)){
                    count++;
                }
                if(judge(one_end)){
                    count++;
                }
                if(judge(five_end)){
                    count++;
                }
                if(judge(i)){
                    count++;
                }
                zero_end += 10;
                one_end += 10;
                five_end += 10;
            }
            System.out.println(count);
        }
    }

    public static boolean judge(int n){
        String pow =Integer.toString(n * n);
        String self = Integer.toString(n);
        int index = pow.length() - self.length();
        if(pow.substring(index).equals(self)){
            return true;
        }
        return false;
    }
}