package 牛客网_华为;

/*
    1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0
    数字不变
    大写字母变 小写字母且后移一位X--y

 */
import java.util.Scanner;

public class HW_21_简单密码破解 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            for(int i=0; i<ch.length; i++){
                if(ch[i]>='a' && ch[i]<='c'){
                    System.out.print(2);
                }else if(ch[i]>='d' && ch[i]<='f'){
                    System.out.print(3);
                }else if(ch[i]>='g' && ch[i]<='i'){
                    System.out.print(4);
                }else if(ch[i]>='j' && ch[i]<='l'){
                    System.out.print(5);
                }else if(ch[i]>='m' && ch[i]<='o'){
                    System.out.print(6);
                }else if(ch[i]>='p' && ch[i]<='s'){
                    System.out.print(7);
                }else if(ch[i]>='t' && ch[i]<='v'){
                    System.out.print(8);
                }else if(ch[i]>='w' && ch[i]<='z'){
                    System.out.print(9);
                }else if(ch[i]>='A' && ch[i]<='Y'){
                    System.out.print((char)(ch[i]+33));
                }else if(ch[i]=='Z'){
                    System.out.print('a');
                }else if(ch[i]>='0' && ch[i]<='9'){
                    System.out.print(ch[i]);
                }
            }
            System.out.print("\n");
        }
    }
}
