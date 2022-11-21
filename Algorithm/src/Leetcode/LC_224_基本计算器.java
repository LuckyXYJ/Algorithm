package Leetcode;

import java.util.Stack;

public class LC_224_基本计算器 {

    public static void main(String[] args) {

        int n = calculate("(1+(4+5+2)-3)+(6+8)");

        System.out.println(n);
    }

    public static int calculate(String s) {

        System.out.println("string---"+ s);

        Stack<Integer> stack = new Stack<>();

        Boolean isMin = false;
        Integer num = 0;

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            System.out.println(c);
            switch(c){
                case '+':
                    System.out.println("push---"+ num * (isMin?-1:1));
                    stack.push(num * (isMin?-1:1));
                    isMin = false;
                    num = 0;
                    break;
                case '-':
                    System.out.println("push---"+ num * (isMin?-1:1));
                    stack.push(num * (isMin?-1:1));
                    isMin = true;
                    num = 0;
                    break;
                case ' ':
                    break;
                case '(':
                    String subStr = s.substring(i);
                    int right = indexOfRight(subStr);
                    stack.push(calculate(s.substring(i + 1, i + right))  * (isMin?-1:1));
                    i = i + right;
                    isMin = true;
                    num = 0;
                    break;
                case ')':
                    return sum(stack);
                default:
                    num = num * 10 + Integer.valueOf(String.valueOf(c));
            }
        }
        System.out.println("push---"+ num);
        stack.push(num * (isMin?-1:1));
        return sum(stack);
    }

    public static int indexOfRight(String s) {

        System.out.println("index---str----"+ s);
        int ln = 0;
        for (int i = 0 ; i < s.length(); i ++) {
            Character c = s.charAt(i);

            if (c == '(') {
                ln ++;
            }else if(c == ')') {
                ln --;
            }

            if (ln == 0) {
                System.out.println("index---"+ i);
                return i;
            }

        }

        return s.length() - 1;
    }

    public static int sum(Stack<Integer> stack) {
        int res = 0;
        while(!stack.isEmpty()) {

            int n = stack.pop();
            System.out.println(n);
            res = res + n;
        }
        System.out.println(res);
        return res;
    }
}
