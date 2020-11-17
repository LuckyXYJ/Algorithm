package 牛客网_华为;

import java.util.Scanner;
/*回文数*/
public class HW_32_中级_字符串运用_密码截取 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(manacher(s));
        }

    }

    public static int manacher(String s) {
        int count =0;//记录最大回文
        StringBuffer sb = new StringBuffer();
        char[] c =s.toCharArray();
        sb.append("#");
        //对字符串进行封装
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
        }
        int[] rad = new int[sb.length()];//记录新字符串以每个字符为中心的最大回文半径
        char[] cl = sb.toString().toCharArray();
        int max=0;//记录已经搜寻到的回文半径能到达右端的最达大值
        int id=0;//记录回文半径能到达最有端的回文字符串的中心
        for (int i = 1; i < cl.length; i++) {
            if (max>i) {
                rad[i]=Math.min(rad[2*id-i], max-i);
            }else {
                rad[i]=1;
            }
            while (i-rad[i]>=0 && i+rad[i]<cl.length && cl[(i-rad[i])]==cl[(i+rad[i])]) {
                rad[i]++;
            }
            if (i+rad[i]>max) {
                max=i+rad[i];
                id=i;
            }
            count=Math.max(count, rad[i]-1);
        }


        return count;
    }
}
