package 牛客网_华为;

import java.util.Scanner;

public class HW_46_按字节截取字符串 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            int n=sc.nextInt();
            char[] ch=str.toCharArray();
            int i=0;  //保存应该生成的子串的索引位置
            int count=0;
            for(int j=0;j<ch.length;j++){
                if(ch[j]>128){
                    //说明是汉字
                    count+=2;  //每一个汉字占两个字符
                    if(count<n){
                        //如果该汉字加入后，任然不会超过所输出的字符个数，那么可以接着输出
                        i++;
                    }
                }
                else{
                    //说明是普通字符
                    count++;
                    if(count<=n){
                        i++;
                    }
                }
            }
            System.out.println(str.substring(0,i));
        }
    }
}
