package 牛客网_华为;

import java.util.Scanner;

public class HW_83_二维数组操作 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int m = cin.nextInt(), n = cin.nextInt();
            if (m > 9 || n > 9) {
                System.out.println(-1);
            } else {
                System.out.println(0);

            }

            int a = cin.nextInt(), b = cin.nextInt(), c = cin.nextInt(), d = cin.nextInt();
            if (a >= 0 && a < m && b >= 0 && b < n && c >= 0 && c < m && d >= 0 && d < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            int row = cin.nextInt();
            if (row >=m || m==9) { //注意m和n若为9则无法插入
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            int col = cin.nextInt();
            if (col >=n || n==9) {
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            int x = cin.nextInt(), y = cin.nextInt();
            if (x >= 0 && x < m && y >= 0 && y < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
