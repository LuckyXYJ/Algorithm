package 牛客网_华为;
import java.util.*;

public class HW_66_配置文件恢复 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, String> hMap = new HashMap<>();

        hMap.put("reset", "reset what");
        hMap.put("reset board", "board fault");
        hMap.put("board add", "where to add");
        hMap.put("board delete", "no board at all");
        hMap.put("reboot backplane", "impossible");
        hMap.put("backplane abort", "install first");

        while(in.hasNext()) {
            String[] str = in.nextLine().split(" ");//以空格分割，一一匹配
            int count = 0;//记录匹配个数
            Set<String> set = hMap.keySet();
            String key = "";
            for (String s : set) {
                String[] a = s.split(" ");
                if (a.length == str.length)
                {
                    int num = 0;
                    for (int i = 0; i < str.length; i++) {
                        int q = a[i].indexOf(str[i]);
                        if(q == 0)
                            num++;
                    }
                    if(num == str.length)
                    {
                        count++;
                        key = s;
                    }

                }
            }
            if(count != 1)
                System.out.println("unknown command");
            else
                System.out.println(hMap.get(key));

        }
    }

}
