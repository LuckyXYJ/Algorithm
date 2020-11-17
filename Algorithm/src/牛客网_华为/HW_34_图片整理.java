package 牛客网_华为;

import java.util.Arrays;
import java.util.Scanner;

public class HW_34_图片整理 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str= scanner.nextLine();
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            for(char c :chars ){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
