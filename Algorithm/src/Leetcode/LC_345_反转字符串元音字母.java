package Leetcode;

public class LC_345_反转字符串元音字母 {

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while(l < r) {
            if(!isYuanyin(cs[l])) {
                l++;
                continue;
            }
            if(!isYuanyin(cs[r])) {
                r--;
                continue;
            }
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
        return new String(cs);
    }

    public boolean isYuanyin(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
