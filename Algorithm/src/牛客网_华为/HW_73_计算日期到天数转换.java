package 牛客网_华为;
import java.util.Scanner;

public class HW_73_计算日期到天数转换 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            int year = sc.nextInt() ;
            int month = sc.nextInt() ;
            int day = sc.nextInt() ;
            int Day = outDay(year, month, day) ;
            System.out.println(Day);
        }
        sc.close();

    }

    private static int outDay(int year, int month, int day) {
        int [] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
        if(year <= 0 ||month <= 0 || month > 12 || day<= 0 || day > Day[month - 1])
            return -1;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            Day[1] = 29 ;
        }

        int sum = 0 ;
        for(int i = 0 ; i < month - 1 ; i ++){
            sum += Day[i] ;
        }
        return sum + day;
    }

}