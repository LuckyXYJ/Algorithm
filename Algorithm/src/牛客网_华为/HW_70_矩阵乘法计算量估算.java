package 牛客网_华为;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * 矩阵的计算量估计
 */

public class HW_70_矩阵乘法计算量估算 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][2];
            for (int i = 0; i < n; i++) {
                matrix[i][0] = scan.nextInt();
                matrix[i][1] = scan.nextInt();
            }

            String expression = scan.next();
            int result = calculateMultiplyingCount(matrix, expression);
            System.out.println(result);
        }
        scan.close();
    }

    // 注意与四则运算的相似和不同的地方，这里只有乘法，所以不需要判断优先级，从左到右即可
    // 栈中是存矩阵的行和列
    //若矩阵表达式为(A(BC(D(EF))))，首先将表达式化成(A(X(D(Y))))，然后通过找")"依次计算
    private static int calculateMultiplyingCount(int[][] matrix, String expression) {

        int result = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int index = 0;
        for (int i = 0; i < expression.length(); i++) {
            char item = expression.charAt(i);
            if (Character.isLetter(item)) {   //若为一个矩阵
                if (!stack.isEmpty()&&stack.peek() != -1) {  //栈顶不为"("时，计算矩阵并合并
                    int col = stack.pop();
                    int row = stack.pop();
                    int col2 = matrix[index][1];
                    result += row * col * col2;

                    stack.push(row);
                    stack.push(col2);
                } else {
                    stack.push(matrix[index][0]);
                    stack.push(matrix[index][1]);
                }
                index++;
            }
            else if (item == '(')
                stack.push(-1);
            else if (item == ')') {
                int col1 = stack.pop();  //弹出栈顶的矩阵
                int row1 = stack.pop();
                stack.pop();             //弹出"("
                if (stack.size() <= 1)
                    return result;
                if (stack.peek() != -1) { //若栈顶不为"("  弹出栈顶矩阵并计算
                    stack.pop();  //col2    排在前面的矩阵
                    int row2 = stack.pop();
                    result += row2 * row1 * col1;
                    row1 = row2;
                }
                stack.push(row1);
                stack.push(col1);
            }

        }
        return result;
    }
}