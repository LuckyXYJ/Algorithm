package 牛客网_华为;

import java.util.*;

public class HW_67_24点游戏算法 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double result=0.0;
        int[] num=new int[4];
        while(input.hasNext()){
            int[] temp=new int[4];
            for(int i=0;i<4;i++){
                num[i]=input.nextInt();
            }
            System.out.println(check(num,temp,result));
        }
        input.close();
    }

    private static boolean check(int[] num,int[] temp,double result) {
        for(int i=0;i<num.length;i++){
            if(temp[i]==0){
                temp[i]=1;
                if(check(num,temp,result+num[i])
                        || check(num,temp,result-num[i])
                        || check(num,temp,result*num[i])
                        || check(num,temp,result/num[i])){
                    return true;
                }
                temp[i]=0;
            }
        }
        if(result==24){
            return true;
        }else{
            return false;
        }
    }
}
