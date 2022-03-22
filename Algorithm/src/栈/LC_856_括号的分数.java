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

import org.junit.Test;

import java.util.Stack;

public class LC_856_括号的分数 {

    public static void main(String[] args) {
        int score = scoreOfParentheses("()(())");
        System.out.println("分数 = " + score);
    }

    @Test
    public void test() {
        int score = scoreOfParentheses2("()(())");
        System.out.println("分数 = " + score);
    }

    public int scoreOfParentheses2(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                stack.push(0);
            }else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w+Math.max(v << 1, 1));
            }
        }
        return stack.pop();
    }

    public int scoreOfParentheses4(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }

    public static int scoreOfParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        Stack<Integer> scoreStack = new Stack<>();
        int len = s.length();
        int score = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.pop() == '(') {
                    score = (score > 0 )? (score*2) : 1;
                    System.out.println("分数2 = " + score);
                }else {
                    score += scoreStack.pop();
                    System.out.println("分数3 = " + score + "; i = " + i);
                    i--;
                }
            }else {
                if (stack.size() > 0 && score > 0) {
                    scoreStack.push(score);
                    stack.push('+');
                    score = 0;
                    System.out.println("分数1 = " + score);
                }
                stack.push(c);
            }
        }

        return score;
    }

}
