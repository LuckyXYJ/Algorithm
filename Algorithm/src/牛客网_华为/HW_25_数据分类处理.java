package 牛客网_华为;

import java.util.*;

public class HW_25_数据分类处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int rn = sc.nextInt();
            String[] st = new String[rn];
            for(int i=0;i<rn;i++){
                st[i] =sc.next();
            }
            int jn = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i=0;i< jn;i++){
                set.add(sc.nextInt());
            }
            StringBuffer str = new StringBuffer();
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                String e = iterator.next().toString();
                str.append(getRes(e,st));
            }
            System.out.println(str.toString().split(" ").length+" "+str);
        }
    }
    public static StringBuffer getRes(String e,String[] st){
        StringBuffer res = new StringBuffer();
        LinkedHashMap<Integer,String> map = new LinkedHashMap<Integer, String>();
        for(int i=0;i<st.length;i++){
            if(st[i].contains(e)){
                map.put(i,st[i]);
            }
        }
        if(map.size()>0)
            res.append(e+" "+map.size()+" ");
        for(Map.Entry entry : map.entrySet()){
            res.append(entry.getKey()+" "+entry.getValue()+" ");
        }
        return res;
    }
}
