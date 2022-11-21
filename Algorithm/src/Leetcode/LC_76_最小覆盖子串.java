package Leetcode;


import org.junit.Test;

/*
* s = "ADOBECODEBANC", t = "ABC"
* */
public class LC_76_最小覆盖子串 {

    public static void main(String[] args) {

        String abcabcbb = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(abcabcbb);
    }

    @Test
    public void test() {
        String abcabcbb = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(abcabcbb);
    }


    public static String minWindow(String s, String t) {
        int l = 0, r = 0, sLen = s.length(), tLen = t.length();

        int[] charNums = new int[128];
        int[] tempNums = new int[128];

        for (int i = 0; i < tLen; i++) {
            charNums[t.charAt(i)] ++;
        }

        int count = 0, start = 0, min = sLen + 1;

        while(r < sLen) {
            char c = s.charAt(r);

            if (charNums[c] == 0) {
                r++;
                continue;
            }

            if (tempNums[c] < charNums[c]) {
                count ++;
            }

            tempNums[c] ++;

            r ++;

            while (count == tLen) {
                if (r - l < min) {
                    min = r - l;
                    start = l;
                }

                char lc = s.charAt(l);

                if (charNums[lc] == 0) {
                    l ++;
                    continue;
                }

                if (tempNums[lc] == charNums[lc]) {
                    count --;
                }

                tempNums[lc] --;
                l ++;
            }

        }

        if (min == s.length() + 1) {
            return "";
        }

        return s.substring(start, start + min);
    }

    public static String minWindows(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
