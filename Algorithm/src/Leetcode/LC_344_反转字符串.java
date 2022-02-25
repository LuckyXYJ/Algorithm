package Leetcode;

public class LC_344_反转字符串 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while(l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
