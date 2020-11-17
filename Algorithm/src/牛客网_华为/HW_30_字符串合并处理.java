package 牛客网_华为;
import java.util.*;
public class HW_30_字符串合并处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            str += sc.next();
            System.out.println(reverseStr(sort(str)));
        }
    }

    public static String reverseStr(String str) {
        if (str == null || "".equals(str))
            return str;
        char[] nums = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : nums) {
            if (c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F' || c >= '0' && c <= '9') {
                String bStr = "0000" + Integer.toBinaryString(Integer.valueOf(c + "", 16));
                bStr = bStr.substring(bStr.length() - 4);
                String oxStr = "";
                for (int i = bStr.length() - 1; i >= 0; i--)
                    oxStr += bStr.charAt(i);
                String res = Integer.toHexString(Integer.parseInt(oxStr, 2)).toUpperCase();
                sb.append(res);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String sort(String str) {
        if (str == null || str.length() == 0)
            return str;
        char[] nums = str.toCharArray();
        for (int k = 0; k < 2; k++) {
            for (int i = k + 2; i < nums.length; i += 2) {
                int j = i - 2;
                char key = nums[i];
                while (j >= 0 && key < nums[j]) {
                    nums[j + 2] = nums[j];
                    j -= 2;
                }
                nums[j + 2] = key;
            }
        }
        return new String(nums);
    }
}
