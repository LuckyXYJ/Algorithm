package 牛客网_华为;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 */

public class HW_08_合并表记录 {

    public static void main(String[] args) {
        test2();
    }

    static void test1(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for(int i = 0;i<num;i++){
                int key =scanner.nextInt();
                int value =scanner.nextInt();
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }
            for(Map.Entry<Integer,Integer> integerEntry :map.entrySet()){
                System.out.println(integerEntry.getKey()+" "+integerEntry.getValue());
            }
        }
    }

    static void test2() {
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(System.in))) {
            String str = null;

            while ((str = br.readLine()) != null) {
                int num = Integer.parseInt(str);
                TreeMap<Integer, Integer> tm = new TreeMap<>();
                for (int i = 0; i < num; i++) {
                    str = br.readLine();
                    String[] strArr = str.split(" ");
                    Integer key = Integer.valueOf(strArr[0]);
                    Integer value = Integer.valueOf(strArr[1]);
                    if(!tm.containsKey(key)) {
                        tm.put(key,value);
                    } else {
                        tm.put(key,tm.get(key) + value);
                    }
                }
                Set<Integer> keySet = tm.keySet();
                for (Integer i : keySet) {
                    System.out.println(i + " " + tm.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
