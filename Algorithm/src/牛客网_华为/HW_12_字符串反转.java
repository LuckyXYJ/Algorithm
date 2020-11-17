package 牛客网_华为;
/**
 * 字符串反转
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输入描述:
 * 输入N个字符
 * 输出描述:
 * 输出该字符串反转后的字符串
 * 示例1
 * 输入abcd
 * 输出dcba
 */
import java.util.Scanner;

public class HW_12_字符串反转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();
        test1(number);
    }

    static void test1(String str) {
        StringBuffer strBuf = new StringBuffer();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            strBuf.append(str.charAt(i));
        }
        System.out.println(strBuf.toString());
    }
}
