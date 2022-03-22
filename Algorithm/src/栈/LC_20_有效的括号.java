package 栈;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class LC_20_有效的括号 {

    /* LeetCode 题解
    * 栈 + 字典
    */
    public boolean isValid(final String s) {

        final int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        final HashMap<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            final char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    /* 栈 */
    public boolean secondIsValid(final String s) {
        final Stack<Character> stack = new Stack<>();
        final int len = s.length();
        for (int i = 0; i < len; i++) {
            final char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                final char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }

    /*渣渣解法。垃圾*/
    public boolean thirdIsValid(String s) {

        while (s.contains("{}") || s.contains("[]") || s.contains("()") ) {
            s = s.replace("{}","");
            s = s.replace("[]","");
            s = s.replace("()","");
        }
        return s.isEmpty();
    }
}
