package 牛客网_华为;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HW_54_表达式求值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Queue q = new LinkedList<String>();
            //将输入的字符拆分存在队列中
            string2queue(s, q);
            //将队列中的中缀表达式 修改为 后缀表达式
            Object[] ss = mid2post(q);
            //获取表达式的值
            getValue(ss);
        }
    }

    public static void string2queue(String s, Queue q) {
        char[] ss = s.toCharArray();
        int x = 0;
        //记录是否还有数字没有放入队列
        boolean y = false;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] >= '0' && ss[i] <= '9') {
                //可能存在两位数或者三位数等等
                x = x * 10 + (int) (ss[i] - '0');
                y = true;
            } else if (" ".equals(String.valueOf(ss[i]))) {
                continue;
            } else {
                if (y) {
                    q.add(String.valueOf(x));
                }
                q.add(String.valueOf(ss[i]));
                x = 0;
                y = false;
            }
        }
        if (y) {
            //最后可能有数字，所以进行判断
            q.add(String.valueOf(x));
        }
    }

    //对符号进行简单的判断优先级
    public static int rank(String a) {
        if ("+".equals(a) || "-".equals(a)) {
            return 1;
        }
        if ("*".equals(a) || a == "\\") {
            return 2;
        } else {
            return 0;
        }
    }

    //将中缀 变为后缀表达   没有用Java自带的栈(Stack，由于java不推荐使用,这里没有使用)
    //用的是双向队列，但是基本上用队列尾部进行输入输出，基本和栈一样
    //思路基本是 中缀到后缀的思路，不记得可以去百度一下，具体不详细在这里解释
    public static Object[] mid2post(Queue q) {
        Queue stack = new LinkedList<String>(); // 存放的是操作数，也是最终的后缀表示式
        Deque stack_char = new LinkedList<String>(); //双向队列，存的是符号 (+ - * /)
        // i 记录之前是否有数字,比如( -5 + 6 )的表达式 遇到 (-)前没有 数字需要添加0，变成( 0 - 5 + 6 )计算
        boolean i = false;
        while (!q.isEmpty()) {
            String s = (String) q.poll();
            if (s.matches("[0-9]+")) {
                stack.add(s);
                i = true;
            } else if (s.equals("(")) {
                stack_char.add(s);
            } else if (s.equals(")")) {
                String x = (String) stack_char.removeLast();
                while (!x.equals("(")) {
                    stack.add(x);
                    x = (String) stack_char.removeLast();
                }
                i = true;
            } else {
                if (s.equals("-") && !i) {
                    stack.add("0");
                }
                String x = (String) stack_char.peekLast();
                while (rank(x) >= rank(s) && x != "(") {
                    stack.add((String) stack_char.removeLast());
                    x = (String) stack_char.peekLast();
                }
                stack_char.add(s);
                i = false;
            }
        }
        while (!stack_char.isEmpty()) {
            stack.add(stack_char.removeLast());
        }
        Object[] ss = stack.toArray();
        return ss;
    }

    //通过之前获得后缀表达式，计算值
    public static int getValue(Object[] ss) {
        Deque stack = new LinkedList<String>();
        int i = 0;
        while (i < ss.length) {
            String x = String.valueOf(ss[i++]);
            if (x.matches("[0-9]+")) {
                stack.add(x);
            } else {
                int num_1 = Integer.parseInt((String) stack.pollLast());
                int num_2 = Integer.parseInt((String) stack.pollLast());
                int num = cal(x, num_2, num_1);
                stack.add(String.valueOf(num));
            }
        }
        System.out.println(stack.poll());
        return 0;
    }

    public static int cal(String a, int x, int y) {
        if (a.equals("+")) {
            return x + y;
        }
        if (a.equals("-")) {
            return x - y;
        }
        if (a.equals("*")) {
            return x * y;
        }
        if (a.equals("/")) {
            return x / y;
        }
        return 0;
    }
}



