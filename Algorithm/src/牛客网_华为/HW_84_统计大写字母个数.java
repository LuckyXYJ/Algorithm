package 牛客网_华为;

import java.util.Scanner;
public class HW_84_统计大写字母个数{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] ch = sc.nextLine().toCharArray();
            int nums = 0;
            for(int i=0;i<ch.length;i++){
                if(ch[i]>='A' && ch[i]<='Z'){
                    nums++;
                }
            }
            System.out.println(nums);
        }
    }
}
