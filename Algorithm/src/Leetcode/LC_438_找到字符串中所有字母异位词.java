package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 *
 *  */
public class LC_438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {

        findAnagrams("cbaebabacd", "abc");

    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int sLen = s.length(), pLen = p.length();
        int[] charNums = new int[26];

        for (int i = 0; i < pLen; i++) {
            charNums[p.charAt(i) - 'a'] ++;
        }

        int l = 0, r = 0;
        while (r < sLen) {

            System.out.println(l+"--"+r);

            if (charNums[s.charAt(r) - 'a'] > 0) {
                charNums[s.charAt(r++) - 'a'] --;
                if (r - l == pLen) {
                    System.out.println(l);
                    result.add(l);
                }
                System.out.println("1111");
            }else {
                charNums[s.charAt(l++) - 'a']++;
                System.out.println("222");
            }

            System.out.println(l+"=="+r);
        }
        return result;
    }
}
