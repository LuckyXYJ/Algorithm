package 牛客网_华为;

import java.util.HashSet;
import java.util.Scanner;

public class HW_10_字符个数统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        test1(input);
    }

    static  void test1(String str) {
        HashSet<Character> chars = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            Character chara = str.charAt(i);
            if (chara < 127 && chara > 0){
                chars.add(str.charAt(i));
            }
        }
        System.out.println(chars.size());
    }

    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        //总共有128个字符。字需要用128位
        BitSet bitSet = new BitSet(128);
        for (char c : line.toCharArray()) {
            //判断字符c是否已出现
            if (!bitSet.get(c)) {
                //未出现就设置为已出现
                bitSet.set(c);
            }
        }
        //统计有多少字符已出现过
        System.out.println(bitSet.cardinality());
    }
    * */
}
