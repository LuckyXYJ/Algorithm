package 牛客网_华为;

import java.util.*;

public class HW_03_明明的随机数 {
    public static void main(String[] args) {


    }

    static void test1() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] intArr = new int[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = scanner.nextInt();
            }
            Arrays.sort(intArr);
            for (int i = 0; i < intArr.length; i++) {
                if (i == 0 || intArr[i] != intArr[i - 1]) {
                    System.out.println(intArr[i]);
                }
            }
        }
    }

    static void test2() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            Set<Integer> numberSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                numberSet.add(scanner.nextInt());
            }
            numberSet.forEach(System.out::println);
        }
    }

    static void test3() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            //获取个数
            int num = scanner.nextInt();
            //创建TreeSet进行去重排序
            TreeSet set = new TreeSet();
            //输入
            for (int i = 0; i < num; i++) {
                set.add(scanner.nextInt());
            }

            //输出
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
