package 牛客网_华为;

//public class HW_81_字符串匹配 {
//}
import java.util.HashMap;
        /* 判断短字符串中的所有字符是否在长字符串中全部出现
         * 遍历长字符串，统计各个字符出现的频率
         * 遍历短字符串的各个字符，在长字符该字符下频率是否为0，如果有为0的就说明不是全部存在，全部不为0，就是全部存在
         * */

import java.util.*;

public class HW_81_字符串匹配 {
    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        while(jin.hasNextLine()) {
            String sh = jin.nextLine();
            String lo = jin.nextLine();
            System.out.println(isMatch(sh, lo));
        }
    }
    public static boolean isMatch(String sh, String lo) {
        for(int i = 0; i < sh.length(); i++) {
            if(!lo.contains(Character.toString(sh.charAt(i))))
                return false;
        }
        return true;
    }
}
