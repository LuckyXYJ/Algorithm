package 牛客网_华为;
import java.util.*;

public class HW_55_练习用挑7 {

    public HW_55_练习用挑7() {
    }

    private boolean conatins7(int n) {
        while (n != 0) {
            if (n % 10 == 7) return true;
            n /= 10;
        }
        return false;
    }

    public int count(int n) {
        int count = 0;
        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0 || conatins7(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HW_55_练习用挑7 solution = new HW_55_练习用挑7();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int res = solution.count(n);
            System.out.println(res);
        }
    }
}