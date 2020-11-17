package 牛客网_华为;
import java.util.*;
public class HW_65_查找两个字符串中的最长公共子串{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String max = s1.length() >= s2.length()?s1:s2;
            String min = s1.length() >= s2.length()?s2:s1;
            int l = 0;
            String s ="";
            for(int i=0;i<min.length();i++){
                for(int j=i+1;j<=min.length();j++){
                    if(max.contains(min.substring(i,j)) && j-i>l){
                        l=j-i;
                        s=min.substring(i,j);
                    }
                }
            }
            System.out.println(s);
        }

    }

}