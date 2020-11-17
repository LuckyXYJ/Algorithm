package 牛客网_华为;

import java.util.*;

public class HW_18_识别有效的IP地址和掩码并进行分类统计 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] count=new int[7];
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] IPandYM=str.split("~");
            String[] YMarray=IPandYM[1].split("\\.");
            String[] IParray=IPandYM[0].split("\\.");
            boolean YMisWrong=false;
            String YMstr="";
            for (int i=0;i<4;i++){
                YMstr=YMstr+getBinary(Integer.valueOf(YMarray[i]));
            }
            if (YMstr.indexOf("0")==-1||YMstr.indexOf("1")==-1||YMstr.indexOf("0")<YMstr.lastIndexOf("1")
                    ||IParray.length!=4||YMarray.length!=4){
                YMisWrong=true;
                count[5]++;


            }
            if (!YMisWrong){
                if(IParray[0]!=""&&Integer.valueOf(IParray[0])>=1&&Integer.valueOf(IParray[0])<=126){
                    if(IParray[1]!=""&&IParray[2]!=""&&IParray[3]!=""&&
                            Integer.valueOf(IParray[1])>=0&&Integer.valueOf(IParray[1])<=255&&
                            Integer.valueOf(IParray[2])>=0&&Integer.valueOf(IParray[2])<=255&&
                            Integer.valueOf(IParray[3])>=0&&Integer.valueOf(IParray[3])<=255){
                        count[0]++;
                        if (Integer.valueOf(IParray[0])==10) count[6]++;
                    }
                }else if(IParray[0]!=""&&Integer.valueOf(IParray[0])>=128&&Integer.valueOf(IParray[0])<=191){
                    if(IParray[1]!=""&&IParray[2]!=""&&IParray[3]!=""&&
                            Integer.valueOf(IParray[1])>=0&&Integer.valueOf(IParray[1])<=255&&
                            Integer.valueOf(IParray[2])>=0&&Integer.valueOf(IParray[2])<=255&&
                            Integer.valueOf(IParray[3])>=0&&Integer.valueOf(IParray[3])<=255){
                        count[1]++;
                        if (Integer.valueOf(IParray[0])==172&&Integer.valueOf(IParray[1])>=16&&Integer.valueOf(IParray[1])<=31) count[6]++;
                    }
                }else if(IParray[0]!=""&&Integer.valueOf(IParray[0])>=192&&Integer.valueOf(IParray[0])<=223){
                    if(IParray[1]!=""&&IParray[2]!=""&&IParray[3]!=""&&
                            Integer.valueOf(IParray[1])>=0&&Integer.valueOf(IParray[1])<=255&&
                            Integer.valueOf(IParray[2])>=0&&Integer.valueOf(IParray[2])<=255&&
                            Integer.valueOf(IParray[3])>=0&&Integer.valueOf(IParray[3])<=255){
                        count[2]++;
                        if (Integer.valueOf(IParray[0])==192&&Integer.valueOf(IParray[1])==168) count[6]++;
                    }
                }else if(IParray[0]!=""&&Integer.valueOf(IParray[0])>=224&&Integer.valueOf(IParray[0])<=239){
                    if(IParray[1]!=""&&IParray[2]!=""&&IParray[3]!=""&&
                            Integer.valueOf(IParray[1])>=0&&Integer.valueOf(IParray[1])<=255&&
                            Integer.valueOf(IParray[2])>=0&&Integer.valueOf(IParray[2])<=255&&
                            Integer.valueOf(IParray[3])>=0&&Integer.valueOf(IParray[3])<=255){
                        count[3]++;
                    }
                }else if(IParray[0]!=""&&Integer.valueOf(IParray[0])>=240&&Integer.valueOf(IParray[0])<=255){
                    if(IParray[1]!=""&&IParray[2]!=""&&IParray[3]!=""&&
                            Integer.valueOf(IParray[1])>=0&&Integer.valueOf(IParray[1])<=255&&
                            Integer.valueOf(IParray[2])>=0&&Integer.valueOf(IParray[2])<=255&&
                            Integer.valueOf(IParray[3])>=0&&Integer.valueOf(IParray[3])<=255){
                        count[4]++;
                    }
                }else{
                    if (Integer.valueOf(IParray[0])!=0&&Integer.valueOf(IParray[0])!=127){
                        count[5]++;
                    }
                }
            }



        }
        System.out.println(count[0]+" "+count[1]+" "+count[2]+" "+count[3]+" "+count[4]+" "+count[5]+" "+count[6]);
    }

    public static String getBinary(int num) {
        int currentNum = num;//存放当前的被除数
        LinkedList<String> list = new LinkedList<String>();//存放余数，也是就二进制数
        if (num==0){
            return "00000000";
        }
        while (currentNum != 0) {
            if (currentNum % 2 == 0) {
                list.addFirst("0");
            } else {
                list.addFirst("1");
            }
            currentNum /= 2;
        }

        StringBuilder sb = new StringBuilder();//当然你可以使用其他形式作为方法的返回
        if (list.size()<8){
            for (int i = 0; i < 8 - list.size(); i++) {
                sb.append("0");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
