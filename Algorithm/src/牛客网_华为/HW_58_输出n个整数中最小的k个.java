package 牛客网_华为;
import java.util.*;
public class HW_58_输出n个整数中最小的k个 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        while(in.hasNext()){
            int n=in.nextInt();
            int k=in.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            for(int j=0;j<k;j++){
                if(j==(k-1))
                    System.out.println(arr[j]);//这个必须是换行 不然过不了 同理必须不空格！
                else
                    System.out.print(arr[j]+" ");
            }
        }
    }
}