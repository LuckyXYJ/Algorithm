package 牛客网_华为;
import java.util.*;
public class HW_94_记票统计{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //统计人头
            int n = scan.nextInt();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
            scan.nextLine();
            String str = scan.nextLine();
            String[] array = str.split(" ");
            for(int i=0;i<array.length;i++){
                map.put(array[i],0);
            }
            map.put("Invalid",0);
            //投票计数
            int m = scan.nextInt();
            scan.nextLine();
            String strr = scan.nextLine();
            String[] arrays = strr.split(" ");
            for(String s :arrays){
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Set<String> set = map.keySet();
            for(String s :set){
                System.out.println(s+" : "+map.get(s));

            }
        }
    }
}