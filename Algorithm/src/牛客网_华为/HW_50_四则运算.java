package 牛客网_华为;
import java.util.*;

public class HW_50_四则运算 {
    // 用于存放一个正括号的集合, 用于简化代码
    static Set<Character> brace = new HashSet<>();
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        // 初始化正括号集合
        brace.add('{');
        brace.add('(');
        brace.add('[');
        while(sc.hasNextLine()){
            // 对字符串做初始化处理，原则有二:
            // 1、处理负数，这里在-前面的位置加入一个0，如-4变为0-4，
            // 细节：注意-开头的地方前面一定不能是数字或者反括号，如9-0,(3-4)-5，这里地方是不能加0的
            // 它的后面可以是数字或者正括号，如-9=>0-9, -(3*3)=>0-(3*3)
            // 2、处理字符串，在最后的位置加#, 主要是为了防止最后一个整数无法处理的问题
            String exp = sc.nextLine().replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0") + "#";
            System.out.println(calculate(exp));
        }
    }
    private static int calculate(String exp){
        // 初始化栈
        Stack<Integer> opStack = new Stack<>();
        Stack<Character> otStack = new Stack<>();

        // 整数记录器
        String num = "";
        for(int i = 0; i < exp.length(); i++){
            // 抽取字符
            char c = exp.charAt(i);
            // 如果字符是数字，则加这个数字累加到num后面
            if(Character.isDigit(c)){
                num += c;
            }
            // 如果不是数字
            else{
                // 如果有字符串被记录，则操作数入栈，并清空
                if(!num.isEmpty()){
                    int n = Integer.parseInt(num);
                    num = "";
                    opStack.push(n);
                }
                // 如果遇上了终结符则退出
                if(c == '#')
                    break;
                    // 如果遇上了+-
                else if(c == '+' || c == '-'){
                    // 空栈或者操作符栈顶遇到正括号，则入栈
                    if(otStack.isEmpty() || brace.contains(otStack.peek())){
                        otStack.push(c);
                    } else {
                        // 否则一直做弹栈计算，直到空或者遇到正括号为止，最后入栈
                        while(!otStack.isEmpty() && !brace.contains(otStack.peek()))
                            popAndCal(opStack, otStack);
                        otStack.push(c);
                    }
                }
                // 如果遇上*/
                else if(c == '*' || c == '/'){
                    // 空栈或者遇到操作符栈顶是括号，或者遇到优先级低的运算符，则入栈
                    if(otStack.isEmpty()
                            || brace.contains(otStack.peek())
                            || otStack.peek() == '+' || otStack.peek() == '-'){
                        otStack.push(c);
                    }else{
                        // 否则遇到*或/则一直做弹栈计算，直到栈顶是优先级比自己低的符号，最后入栈
                        while(!otStack.isEmpty()
                                && otStack.peek() != '+' && otStack.peek() != '-'
                                && !brace.contains(otStack.peek()))
                            popAndCal(opStack, otStack);
                        otStack.push(c);
                    }
                } else {
                    // 如果是正括号就压栈
                    if(brace.contains(c))
                        otStack.push(c);
                    else{
                        // 反括号就一直做弹栈计算，直到遇到正括号为止
                        char r = getBrace(c);
                        while(otStack.peek() != r){
                            popAndCal(opStack, otStack);
                        }
                        // 最后弹出正括号
                        otStack.pop();
                    }
                }
            }
        }
        // 将剩下的计算完，直到运算符栈为空
        while(!otStack.isEmpty())
            popAndCal(opStack, otStack);
        // 返回结果
        return opStack.pop();
    }
    private static void popAndCal(Stack<Integer> opStack, Stack<Character> otStack){
        int op2 = opStack.pop();
        int op1 = opStack.pop();
        char ot = otStack.pop();
        int res = 0;
        switch(ot){
            case '+':
                res = op1 + op2;
                break;
            case '-':
                res = op1 - op2;
                break;
            case '*':
                res = op1 * op2;
                break;
            case '/':
                res = op1 / op2;
                break;
        }
        opStack.push(res);
    }
    private static char getBrace(char brace){
        switch(brace){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return '#';
    }
}
