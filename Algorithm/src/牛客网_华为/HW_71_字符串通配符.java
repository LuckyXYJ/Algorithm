package 牛客网_华为;
import java.util.Scanner;
public class HW_71_字符串通配符{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String zhengze = sc.next();
            String s = sc.next();
            zhengze = zhengze.replaceAll("\\?","[\\\\w]{1}");
            zhengze = zhengze.replaceAll("\\*","[\\\\w]*");
            System.out.println(s.matches(zhengze));
        }
        sc.close();
    }
}
