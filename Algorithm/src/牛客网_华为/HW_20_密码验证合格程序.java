package 牛客网_华为;

import java.util.Scanner;

public class HW_20_密码验证合格程序 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int[] judge = new int[3];
            int len = str.length();
            //1.长度超过8位
            if(len > 8){
                judge[0] = 1;
            }
            //2.包括大小写字母.数字.其它符号,以上四种至少三种
            int[] judgeChar = new int[4];
            int count = 0;
            for(int i = 0; i < len; i++){
                char c = str.charAt(i);
                if(c >= 'a' && c <= 'z'){
                    if(judgeChar[0] > 0){

                    }else{
                        judgeChar[0]++;
                        count++;
                    }
                }else if(c >= 'A' && c <= 'Z'){
                    if(judgeChar[1] > 0){

                    }else{
                        judgeChar[1]++;
                        count++;
                    }
                }else if(c >= '0' && c <= '9'){
                    if(judgeChar[2] > 0){

                    }else{
                        judgeChar[2]++;
                        count++;
                    }
                }else{
                    if(judgeChar[3] > 0){

                    }else{
                        judgeChar[3]++;
                        count++;
                    }
                }
            }
            if(count >= 3){
                judge[1] = 1;
            }
            //3.不能有相同长度大于2的子串重复
            String subStr = new String();
            int flag = 0;
            for(int i = 0; i < len - 4; i++){
                subStr = str.substring(i,i + 3);
                if(str.substring(i + 1).contains(subStr)){
                    flag = 1;
                }
            }
            if(flag == 0){
                judge[2] = 1;
            }

            if(judge[0] == 1 && judge[1] == 1 && judge[2] == 1){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
        sc.close();
    }
}
