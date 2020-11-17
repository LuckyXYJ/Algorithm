package 牛客网_华为;

//Java 思路
//按插入顺序读，可以用LinkedHashMap

// 有重复的名字，重复的分数 所以用 name + " " + score 做key，用score做value

//先将分数排序，再遍历分数（该分数i只找一次）

//每次从LinkedHashMap中遍历，找到与i相等的key

import java.util.*;
public class HW_68_成绩排序{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int order = sc.nextInt();
            ArrayList<Integer> list = new ArrayList();
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                list.add(score);
                map.put(name + " " + score, score);
            }
            Collections.sort(list);
            if (order == 0)
                Collections.reverse(list);
            int pre = -1;
            for (int i : list) {
                if (pre == i)
                    continue;
                for (String key : map.keySet())
                    if (map.get(key).equals(i))
                        System.out.println(key);
                pre = i;
            }
        }
    }
}
