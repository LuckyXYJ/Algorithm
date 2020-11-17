package 牛客网_华为;

import java.util.Scanner;

public class HW_31_中级_单词倒排 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine().replaceAll("[^a-zA-Z]+", " ").trim();
            String[] words=str.split(" ");
            String result="";
            for(int i=words.length-1;i>=0;i--){
                result=result+words[i]+" ";
            }
            System.out.println(result.substring(0,result.length()-1));
        }

    }
}
