package 牛客网_华为;
import java.util.*;

public class HW_A00_等差数列 {

    private int sum(int n) {
        return (1 + 3*n) * n / 2;
    }

    public HW_A00_等差数列() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int res = sum(n);
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        HW_A00_等差数列 solution = new HW_A00_等差数列();
    }
}