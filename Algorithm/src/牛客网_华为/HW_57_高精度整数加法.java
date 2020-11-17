package 牛客网_华为;
import java.math.BigInteger;
import java.util.Scanner;
public class HW_57_高精度整数加法 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String a=in.next();
            String b=in.next();
            BigInteger c=new BigInteger(a);
            BigInteger d=new BigInteger(b);
            System.out.println(c.add(d));
        }
    }
}