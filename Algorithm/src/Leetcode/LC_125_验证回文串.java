package Leetcode;

public class LC_125_验证回文串 {
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while(l < r) {
            if(!((cs[l] >= 'a' && cs[l] <= 'z')||(cs[l] >= 'A' && cs[l] <= 'Z')||(cs[l] >= '0' && cs[l] <= '9'))) {
                l++;
                continue;
            }
            if(!((cs[r] >= 'a' && cs[r] <= 'z')||(cs[r] >= 'A' && cs[r] <= 'Z')||(cs[r] >= '0' && cs[r] <= '9'))) {
                r--;
                continue;
            }


            if((cs[l] >= '0' && cs[l] <= '9')||(cs[r] >= '0' && cs[r] <= '9')) {
                if(cs[l] != cs[r]) return false;
            }


            if(!(cs[l] == cs[r] || cs[l] - cs[r] == 'a' - 'A' || cs[l] - cs[r] == 'A' - 'a')) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
