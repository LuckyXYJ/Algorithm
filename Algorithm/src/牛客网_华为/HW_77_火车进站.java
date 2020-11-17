package 牛客网_华为;
import java.util.*;

public class HW_77_火车进站 {
    static ArrayList<String> l=new ArrayList<String>();    //储存结果
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            l.clear();    //静态变量，每次先清空
            int nums=in.nextInt();
            int[] id=new int[nums];
            Stack<Integer> stack=new Stack<Integer>();
            for(int i=0;i<nums;i++) {
                id[i]=in.nextInt();
            }
            trainOut(id,0,stack,"",0);
            Collections.sort(l);    //对结果集排序
            for(String str:l) {
                System.out.println(str);
            }
        }
        in.close();
    }
    //i为入栈次数，n为出栈次数，str存储一趟结果
    public static void trainOut(int[] id,int i,Stack<Integer> s,String str,int n) {
        if(n==id.length) {
            l.add(str);    //如果所有火车均出栈则将当前结果保存
        }
        if(!s.empty()) {       //栈非空时出栈
            int temp=s.pop();
            trainOut(id,i,s,str+temp+" ",n+1);
            s.push(temp);    //恢复现场
        }
        if(i<id.length) {    //若所有火车没有都入栈则入栈
            s.push(id[i]);
            trainOut(id,i+1,s,str,n);
            s.pop();        //恢复现场
        }
    }
}