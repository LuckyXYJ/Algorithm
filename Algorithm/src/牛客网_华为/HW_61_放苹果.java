package 牛客网_华为;
import java.util.*;

public class HW_61_放苹果{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m<1 || n>10){
                System.out.println(-1);
            }else{
                System.out.println(shareCount(m,n));
            }

        }
    }
    public static int shareCount(int m, int n){
        if(m<0){
            return 0;
        }
        if(m==1 || n==1){
            return 1;
        }
        return shareCount(m, n-1)+shareCount(m-n,n);
    }
}