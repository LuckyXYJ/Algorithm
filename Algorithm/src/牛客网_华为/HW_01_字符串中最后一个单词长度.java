package 牛客网_华为;
import java.util.Scanner;


public class HW_01_字符串中最后一个单词长度 {

    public static int lengthOfLast(String str) {
        String[] s = str.split(" ");
        return s[s.length-1].length();
    }

    public static int lengthOfLast2(String str) {
        int count = 0;
        for (int i = str.length() - 1; i >= 0 ; i--) {
            if (str.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){

            String str = scan.nextLine();
            System.out.println(lengthOfLast(str));
        }
    }
}
