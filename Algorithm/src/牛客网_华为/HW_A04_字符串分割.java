package 牛客网_华为;

import java.util.*;

public class HW_A04_字符串分割 {

    private List<String> list;

    public HW_A04_字符串分割() {
        list = new LinkedList<>();
    }

    /*****************************************************************************
     功能:存储输入的字符串

     输入:字符串

     输出:无

     返回:0表示成功,其它返回-1
     ******************************************************************************/

    public int addString(String strValue) {
        if (strValue.length() == 0) {
            return -1;
        }
        int i;
        for (i = 0; i + 8 <= strValue.length(); i += 8) {
            list.add(strValue.substring(i, i + 8));
        }
        if (strValue.length() % 8 != 0) {
            StringBuilder last = new StringBuilder(strValue.substring(i));
            while (last.length() < 8) {
                last.append("0");
            }
            list.add(last.toString());
        }
        return 0;
    }

    /****************************************************************************
     功能:获取补位后的二维数组的长度

     输入:无

     输出:无

     返回:二维数组长度
     *****************************************************************************/

    public int getLength() {
        return list.size();
    }

    /*****************************************************************************
     功能:将补位后的二维数组，与输入的二维数组做比较

     输入:strInput:输入二维数组,iLen：输入的二维数组的长度

     输出:无

     返回:若相等,返回0;不相等,返回-1.其它:-1;
     ******************************************************************************/
    public int arrCmp(String strInput[], int iLen) {
        if (list.size() == iLen) return  0;
        else                     return -1;
    }

    public void print() {
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            HW_A04_字符串分割 solution = new HW_A04_字符串分割();
            int n = Integer.parseInt(in.next());
            String[] strInput = new String[n];
            for (int i = 0; i < n; i++) {
                strInput[i] = in.next();
                solution.addString(strInput[i]);
            }
            solution.print();
        }
    }
}