package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC_3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int l = 0, r = 0, len = s.length();

        char[] clist = s.toCharArray();
        int[] arr = new int[128];

        int result = 0;

        for (int i = 0; i < len; i++) {
            if (arr[clist[i]] == 0) {
                arr[clist[i]] = 1;
                r ++;
            }else {
                result = Math.max(r - l, result);
                for (int j = l; j < r; j++) {
                    if (clist[i] == clist[j]) {
                        l = j+1;
                        break;

                    }
                }
                r ++;
            }
        }
        result = Math.max(r - l, result);

        return result;
    }

//    public static int lengthOfLongestSubstring1(String s) {

//        Set<Character> set = new HashSet<>();
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        int l = 0, r = 0, max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                l = map.get(s.charAt(i)) + 1;
//            }else {
//                r =
//            }
//
//        }
//    }
}
