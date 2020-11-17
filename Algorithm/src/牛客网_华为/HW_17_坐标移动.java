package 牛客网_华为;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW_17_坐标移动 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            test1(str);
        }
    }

    static void test1(String str) {
        String[] strArr = str.split(";");
        int x = 0 , y = 0;
        String res = "[ADWS]\\d{1}\\d?";

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].matches(res)){

                int a = Integer.valueOf(strArr[i].substring(1));
                if (strArr[i].charAt(0) == 'A') {
                    x -= a;
                }else if (strArr[i].charAt(0) == 'D') {
                    x += a;
                }else if (strArr[i].charAt(0) == 'W') {
                    y += a;
                }else if (strArr[i].charAt(0) == 'S') {
                    y -= a;
                }
            }
        }
        System.out.println(x+","+y);
    }

    static void test2(String s) {
        int x = 0 , y = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String[] sArray = s.split(";");
        String res = "[ADWS]\\d{1}\\d?";
        for(int i = 0;i < sArray.length;i ++) {
            if(sArray[i].matches(res))
                map.put(sArray[i].charAt(0),map.getOrDefault(sArray[i].charAt(0), 0)+Integer.valueOf(sArray[i].substring(1)));
        }
        x = x - map.get('A') + map.get('D');
        y = y - map.get('S') + map.get('W');
        System.out.println(x+","+y);
        map.clear();
    }
}
