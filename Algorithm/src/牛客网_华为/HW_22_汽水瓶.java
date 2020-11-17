package 牛客网_华为;

import java.util.Scanner;

/*
    3空瓶换一瓶，可以借一个空瓶

    最优解 n/2
    非最优解
 */
public class HW_22_汽水瓶 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        while (sca.hasNext()){
            int num = sca.nextInt();
            if (num == 0){
                break;
            }
            System.out.println(getResult(num));
        }
    }
    public static int getResult(int x){
        if (x >=3 ){
            x = x - 3 + 1;
            return 1 + getResult(x);
        }else if(x == 2){
            x = x -1;
            return 1 +getResult(x);
        }
        else {
            return 0;
        }
    }
}
