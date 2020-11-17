package 牛客网_华为;

import java.util.Scanner;

public class HW_09_提取不重复的整数 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            test1(num);
        }

    }

    static void test1(Integer num) {
        char[] chars= (num+"").toCharArray();
        String str ="";
        for(int i= chars.length-1; i>= 0;i--){
            if(!str.contains(chars[i]+"")){
                str +=chars[i];
            }
        }
        System.out.println(Integer.valueOf(str));
    }

    /*
    #include <stdio.h>
    #include <string.h>

    int main(void)
    {
        int n,m=0;
            scanf("%d",&n);
            int a[10]={0};
            while(n)
            {
                if(a[n%10] == 0)
                {
                    a[n%10]++;
                    m = m*10 + n%10;
                }
                n /= 10;
            }
            printf("%d\n",m);
        return 0;
    }
    * */
}
