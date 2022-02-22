package 牛客网_华为;

//import sun.applet.Main;

import java.util.Arrays;
import java.util.Scanner;

public class HW_45_名字的漂亮度 {
    private final int N = 26;

    public HW_45_名字的漂亮度() {
    }

    public int count(String name) {
        int[] arr = new int[N];
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            arr[ch - 'a']++;
        }
        Arrays.sort(arr);
        int result = 0;
        for (int weight = N, i = N - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                result += weight * arr[i];
                weight--;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        HW_45_名字的漂亮度 solution = new HW_45_名字的漂亮度();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String name = in.nextLine().toLowerCase();
                int result = solution.count(name);
                System.out.println(result);
            }
        }
    }
}
