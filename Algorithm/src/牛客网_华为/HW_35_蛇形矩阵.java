package 牛客网_华为;

import java.util.Scanner;

public class HW_35_蛇形矩阵 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int a = 1;
            int b = 0;
            for(int i=0;i<n;i++){
                a = a +i;
                b = a;
                for(int j=0;j<n-i;j++){
                    str.append(b+" ");
                    b = b+ j+i+2;
                }
                System.out.println(str.toString().trim());
                str = new StringBuffer();
            }
        }
    }
}
