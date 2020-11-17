package 牛客网_华为;

import java.util.Scanner;

public class HW_37_统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int mon= scanner.nextInt();
            System.out.println(getNum(mon));
        }
    }
    public static int getNum(int mon){
        if(mon == 1 ||mon == 2){
            return 1;
        }
        return getNum(mon-1)+getNum(mon-2);
    }
}
