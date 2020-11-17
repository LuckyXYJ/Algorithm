package 牛客网_华为;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class HW_36_字符串加密 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            LinkedHashSet<Character> set = new LinkedHashSet();
            for (int i = 0; i < chars1.length; i++) {
                set.add(chars1[i]);
            }
            int k = 0;
            while (set.size() < 26) {
                char a = (char) ('A' + k);
                set.add(a);
                k++;
            }
            ArrayList<Character> list = new ArrayList<>(set);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] == ' ') {
                    sb.append(chars2[i]);
                } else if (chars2[i] < 'a') {
                    int n = (int) (chars2[i] - 'A');
                    char c = list.get(n);
                    sb.append(c);
                } else {
                    int n = (int) (chars2[i] - 'a');
                    char c = (char)(list.get(n)+'a'-'A');
                    sb.append(c);
                }

            }

            System.out.println(sb.toString());
        }
    }
}
