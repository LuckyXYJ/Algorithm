package 栈;
/*
 * https://leetcode-cn.com/problems/score-of-parentheses/
 *  () 得 1 分。
    AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
    (A) 得 2 * A 分，其中 A 是平衡括号字符串。
    * () 1
    * (()) 2
    * ()() 2
    * (()(()))  6
 */

import java.util.Stack;

public class LC_856_括号的分数 {
    public int scoreOfParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int score = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                int sc = 0;
                while (stack.pop() != '(') {
                    sc += 1;
                }

            }else {
                stack.push(c);
            }
        }

        return 0;
    }

    public int scoreOfParentheses1(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int score = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')'){
                int score1 = 1;
                if (i + 1 < len) {
                    char r = s.charAt(i+1);
                    if (r == ')'){
                        score1 *= 2;
                    }else {

                    }
                }
            }
        }
        return 0;
    }

}
