package 牛客网_华为;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HW_14_字符串排序 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextLine();
        }

        test1(array);
    }

    static void test1(String[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (!compare(array[min],array[j])) {
                    min = j;
                }
            }
            if (min == i) continue;

            String temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        for (String str : array) {
            System.out.println(str);
        }
    }

    static boolean compare(String str,String right) {
        int index = 0;
        while (str.charAt(index) == right.charAt(index)) {
            index ++;
            if (index >= str.length()) {
                return true;
            }
            if (index >= right.length()) {
                return false;
            }
        }
        return str.charAt(index) < right.charAt(index);
    }

    //这能算算法题？
    static void test2(String[] array){

        Arrays.sort(array);
        for (String str : array) {
            System.out.println(str);
        }
    }
}
