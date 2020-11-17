package 牛客网_华为;

import java.util.Scanner;
public class HW_72_百钱买百鸡问题{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            for(int n1 = 0 ; n1 < 14;n1++){
                for(int n2 = 0; n2 <= 25;n2++){
                    if(7*n1+4*n2==100){
                        int n3 = 100 - n1 - n2;
                        System.out.println(n1+" "+n2+" "+n3);
                    }
                }
            }
        }
        sc.close();
    }
}