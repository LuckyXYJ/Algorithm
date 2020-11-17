package 牛客网_华为;

import java.util.Scanner;

public class HW_38_小球落地5次经理路程和第五次反弹高度 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            double sum = 0;
            double temp = n;
            for(int i = 0; i < 5; i++){
                sum += temp * 2;
                temp = temp / 2;
            }
            //第一次按它先弹上来再掉下去算的，要减掉第一次弹上来的路程
            sum -= n;
            System.out.printf("%.6f\n",sum);
            System.out.printf("%.6f\n",temp);
        }
    }
}
