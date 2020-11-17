package 牛客网_华为;

import java.util.Scanner;

public class HW_24_合唱队 {
    /**
     计算最少出列多少位同学，使得剩下的同学排成合唱队形
     */

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int total = scan.nextInt();
            int[] arr = new int[total+1];
            for(int i = 1 ; i <= total ; i++){
                arr[i] = scan.nextInt();
            }
            int[] l = left(arr);
            int[] r = right(arr);
            int max = 0;
            for(int i = 0 ; i < arr.length ; i++){
                if(max < (l[i]+r[i]-1)){
                    max = l[i]+r[i]-1;
                }
            }
            System.out.println(total -max);

        }
    }
    //186 186 150 200 160 130 197 200
    // 1   1   1   2   2   1   3   4
    //LIs:上升子序列长度
    //f(i): 已arr[i]结尾的LIS
    //如果左边的数：arr[j] < arr[i]
    // f(i) = f(j)+1
    // arr[j+1] < arr[i]
    // f(i) = f(j+1)+1
    //最长LIS: max{ f(j)+1,f(j+1)+1 }
    public static  int[]  left(int[] arr){
        int[] left = new int[arr.length];
        for(int i =1 ; i < arr.length ; i++){
            left[i] = 1;
            for(int j = 1 ; j < i ;j++){
                if(arr[j] < arr[i]){
                    left[i] = Math.max(left[i],left[j]+1);
                }
            }
        }
        return left;
    }
    //186 186 150 200 160 130 197 200
    public static  int[]  right(int[] arr){
        int[] right= new int[arr.length];
        for(int i =arr.length-1 ; i > 0; i--){
            right[i] = 1;
            for(int j = arr.length-1; j >i ;j--){
                if(arr[j] < arr[i]){
                    right[i] = Math.max(right[i],right[j]+1);
                }
            }
        }
        return right;
    }
}
