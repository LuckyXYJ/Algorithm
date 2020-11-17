package 牛客网_华为;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

public class HW_13_句子逆序 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        test1(input);
    }

    static void test1(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] arr = str.split("\\s");
        for (String s : arr) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}
