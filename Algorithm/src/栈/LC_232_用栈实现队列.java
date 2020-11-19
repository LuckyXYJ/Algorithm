package 栈;
import java.util.Stack;

/**
 * 1、两个栈，一个负责入队，一个负责出队。出队时判断出队栈是否为空，若为空，从入队栈中依次出栈，并加入出栈栈
 *      入队 O(1)  出队 最好O(1) 最差O(n) 平均 O(1)
 *
 */

public class LC_232_用栈实现队列 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public LC_232_用栈实现队列() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(Integer.valueOf(x));
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.empty()){
            while (!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        if (!outStack.empty()) {
            return outStack.pop();
        }
        return  -1;
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.empty()){
            while (!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }
        if (!outStack.empty()) {
            return outStack.peek();
        }
        return  -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

}
