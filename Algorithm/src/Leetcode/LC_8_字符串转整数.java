package Leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC_8_字符串转整数 {

    @Test
    public void test(){

        System.out.println(myAtoi(" -1010023630o4"));
    }

    public int myAtoi(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        int len = s.length();
        boolean isBig = true;

        while (i < len && s.charAt(i) == ' '){
            i++;
        }

        while (i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') isBig = false;
            i++;
            break;
        }

        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            list.add(s.charAt(i) - '0');
            System.out.print(s.charAt(i));
            i++;
        }
        System.out.print('\n');
        int scale = 1;
        Integer result = 0;
//        && result <= 2147483647
        boolean max = false;

        System.out.println(list);

        while (!list.isEmpty()) {
            System.out.print(list.peekFirst());
            System.out.print(',');
            if (result*10 + list.peekFirst() < Integer.MAX_VALUE/10 ) {
                result = result*10 + list.pollFirst();
                scale = scale*10;
            }else if (result*10 + list.peekFirst() == Integer.MAX_VALUE/10 ) {
                result = result*10 + list.pollFirst();
                if (isBig) {
                    System.out.print("\n1www\n");
                    System.out.println(list.peekFirst());
                    System.out.println(list.size());
                    return (list.peekFirst() > 7 || (list.size() > 1)) ? Integer.MAX_VALUE : result*10 + list.pollFirst();
                }else {
                    System.out.print('\n');
                    return (list.peekFirst() > 8 || (list.size() > 1)) ? Integer.MIN_VALUE : 0 - (result*10 + list.pollFirst());
                }
            }else {
                result = result*10 + list.pollFirst();
                if (list.isEmpty()) {
                    break;
                }else {
                    return isBig?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }

            }
        }
        System.out.print('\n');
        return isBig?result:0-result;
    }
}
