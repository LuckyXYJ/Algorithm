package 栈;

//import sun.jvm.hotspot.oops.Mark;
import sun.lwawt.macosx.CSystemTray;

import java.util.Stack;

/*
* https://leetcode-cn.com/problems/basic-calculator/
*
* */

/*
calculate2 自己写的，性能不好
 */


public class LC_224_基本计算器 {

    public static void main(String[] args) {
        int r = calculate2("-(-1+2)");
        System.out.println(r);
        return;
    }

    public static int evaluateExpr(Stack<Object> stack) {

        int res = 0;

        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        // Evaluate the expression till we get corresponding ')'
        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public static int calculate(String s) {

        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                // Forming the operand - in reverse order.
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {

                    // Save the operand on the stack
                    // As we encounter some non-digit.
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {

                    int res = evaluateExpr(stack);
                    stack.pop();

                    // Append the evaluated result to the stack.
                    // This result could be of a sub-expression within the parenthesis.
                    stack.push(res);

                } else {
                    // For other non-digits just push onto the stack.
                    stack.push(ch);
                }
            }
        }

        //Push the last operand to stack, if any.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }

    public int calculate3(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }


//    Mark 自己写的;
    public static int calculate2(String s) {


        Stack<String> stack = new Stack<>();

        s = s.replace(" ","");

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            System.out.println(stack);
            switch (c){
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    jisuan(stack);
                    break;
                case ' ':
                case '+':
                    stack.push("+");
                    break;
                case '-':
                    stack.push("-");
                    break;
                default:
                    int w = quzhi2(s,i);
                    stack.push(s.substring(i,i + w));
                    i = i + w - 1;
                    break;
            }
        }

        int result = 0;
        System.out.println("=====");
        System.out.println(stack);
        result = jisuan2(stack);
        return result;
    }

    public static int quzhi2(String s,int start) {
        int len = 1;
        if (start >= s.length()-1) return len;

        while (start + len < s.length() && !"()+- ".contains(String.valueOf(s.charAt(start + len)))) {
            len++;
        }
        return len;
    }

    public static int quzhi(String s,int start) {


        if (start >= s.length()-1) return 1;
        char c = s.charAt(start+1);
        int len = 1;
        while (!"()+- ".contains(String.valueOf(c)) && start + len >= s.length()-1){
            len ++;
            c = s.charAt(start + len);
        }
        return len;
    }

    public static void jisuan(Stack<String> stack) {
        int result = 0;
        String c = stack.pop();


        int temp = 0;
        while (c != "(" && !stack.isEmpty()){

            if (c == "+"){
                result += temp;
            }else if(c == "-"){
                result -= temp;
            }else {
                temp = Integer.parseInt(c);
            }

            c = stack.pop();
        }

        if (c == "(") {
            result += temp;
        }

        stack.push(String.valueOf(result));
    }

    public static int jisuan2(Stack<String> stack) {
        int result = 0;
        String c = stack.pop();


        int temp = 0;
        while (c != "(" && !stack.isEmpty()){

            if (c == "+"){
                result += temp;
            }else if(c == "-"){
                result -= temp;
            }else {
                temp = Integer.parseInt(c);
            }

            c = stack.pop();
        }

        if (c == "(") {
            result += temp;
        }

        if (stack.isEmpty()) {
            result += Integer.parseInt(c);;
        }


        return result;
    }
}
