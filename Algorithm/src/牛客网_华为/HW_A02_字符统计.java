package 牛客网_华为;

import java.util.Scanner;

public class HW_A02_字符统计{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int[] mat = new int[256];
            for(int i=0;i<str.length();i++){
                if((str.charAt(i)>='a' && str.charAt(i)<='z')||(str.charAt(i)>='A' && str.charAt(i)<='Z')||(str.charAt(i)>='0' && str.charAt(i)<='9'||str.charAt(i)==' ')){
                    int pos = str.charAt(i);
                    mat[pos]++;
                }
            }
            int max = 0;
            for(int i =0;i<256;i++){
                if(mat[i]>max)
                    max = mat[i];
            }
            String res = "";
            for(int j=max;j>0;j--){
                for(int k=0;k<256;k++){
                    if(mat[k]==j)
                        res+=(char)k;
                }
            }
            System.out.println(res);
        }
        in.close();
    }
}