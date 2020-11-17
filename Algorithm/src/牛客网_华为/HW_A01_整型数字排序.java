package 牛客网_华为;
import java.util.*;
public class HW_A01_整型数字排序{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            Arrays.sort(a);
            int b=in.nextInt();
            if(b==0){
                for(int i=0;i<a.length;i++){
                    System.out.print(a[i]+" ");
                }
            }
            if(b==1){
                for(int i=a.length-1;i>=0;i--){
                    System.out.print(a[i]+" ");
                }
            }
            System.out.println();
        }
    }
}