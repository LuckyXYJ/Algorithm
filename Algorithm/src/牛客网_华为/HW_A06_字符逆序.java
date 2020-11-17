package 牛客网_华为;
import java.util.Scanner;

public class HW_A06_字符逆序 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String  rts = "";
        for(int i=0;i<str.length();i++){
            rts=str.substring(i,i+1)+rts;
        }
        System.out.println(rts);
    }
}
