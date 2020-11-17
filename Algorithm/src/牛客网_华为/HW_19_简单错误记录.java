package 牛客网_华为;
import java.io.*;
import java.util.*;

public class HW_19_简单错误记录 {
    public static void main(String[] args) throws IOException{
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> m=new LinkedHashMap<String,Integer>();
        String tstr=null;
        while((tstr = cin.readLine()) != null && !tstr.equals("")){      //&& !tstr.equals(""))没有性能影响
            String[] str=tstr.split("\\s+");
            String fname=str[0].substring(str[0].lastIndexOf("\\")+1);
            fname=fname.substring(Math.max(fname.length()-16 ,0))+" "+str[1];  //max 最快推荐 ？：也可以 if太麻烦
            Integer tmp=m.get(fname);  //get==null较快写法
            if(tmp==null)
                m.put(fname,1);
            else
                m.put(fname, tmp+1);
        }
        int cnt=0;
        for(Map.Entry<String,Integer> it:m.entrySet()){
            if(m.size()-cnt<=8)
                System.out.println(it.getKey()+" "+it.getValue());
            cnt++;
        }
    }
}
