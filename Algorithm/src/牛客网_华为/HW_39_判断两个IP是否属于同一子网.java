package 牛客网_华为;

import java.util.*;

public class HW_39_判断两个IP是否属于同一子网 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a=sc.next();
            String b=sc.next();
            String c=sc.next();
            String[] aa=a.split("\\.");
            String[] bb=b.split("\\.");
            String[] cc=c.split("\\.");
            int[] aaa=Arrays.stream(aa).mapToInt(Integer::parseInt).toArray();
            int[] bbb=Arrays.stream(bb).mapToInt(Integer::parseInt).toArray();
            int[] ccc=Arrays.stream(cc).mapToInt(Integer::parseInt).toArray();
            if(!isIp(bbb)||!isIp(ccc)||!isAd(aaa)){
                System.out.println(1);
                continue;
            }
            boolean flag=true;
            for(int i=0;i<4;i++){
                if((bbb[i]&aaa[i])!=(ccc[i]&aaa[i])){
                    System.out.println(2);
                    flag=false;
                    break;
                }
            }
            if(flag)
                System.out.println(0);


        }
        sc.close();
    }

    public static boolean isAd(int[] a){
        return a[0]>=0&&a[0]<=255&&
                a[1]>=0&&a[1]<=255&&
                a[2]>=0&&a[2]<=255&&
                a[3]>=0&&a[3]<=255&&
                a[0]>=a[1]&&
                a[1]>=a[2]&&
                a[2]>=a[3];
    }

    public static boolean isIp(int[] a){
        return a[0]>=0&&a[0]<=255&&
                a[1]>=0&&a[1]<=255&&
                a[2]>=0&&a[2]<=255&&
                a[3]>=0&&a[3]<=255;
    }
}
