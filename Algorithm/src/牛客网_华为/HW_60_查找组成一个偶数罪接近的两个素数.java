package 牛客网_华为;
import java.util.*;
public class HW_60_查找组成一个偶数罪接近的两个素数 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] res=new int[2];
            for(int i=1;i<=n/2;i++){
                if(isPrime(i) && isPrime(n-i)){
                    res[0]=i;
                    res[1]=n-i;
                }
            }
            System.out.println(res[0]);
            System.out.println(res[1]);
        }
        sc.close();
    }

    private static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }
}