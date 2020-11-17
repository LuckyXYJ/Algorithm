package 牛客网_华为;
import java.util.*;

public class HW_91_2013JAVA题目2_3级
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int top = factorial(m+n);
            int behind = factorial(m)*factorial(n);
            System.out.println(top/behind);
        }
    }

    public static int factorial(int n)
    {
        int sum = 1;
        for(int i = 1;i<=n;i++)
        {
            sum *= i;
        }
        return sum;
    }
}