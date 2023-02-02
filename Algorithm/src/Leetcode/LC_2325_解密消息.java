package Leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_2325_解密消息 {

    @Test
    public void test() {

        decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char r = 'a';
        for (int i = 0; i < key.length(); i++) {

            char c = key.charAt(i);
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, r);
                r++;
            }
        }
        System.out.print(map);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            System.out.print(c);
            if (map.containsKey(c)) {
                System.out.print(c);
                c = map.get(c);
                System.out.print(c);
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
