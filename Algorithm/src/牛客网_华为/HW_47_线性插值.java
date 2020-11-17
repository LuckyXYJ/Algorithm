package 牛客网_华为;
/*只通过70%是因为当遇到重复项时,我们应该丢弃后出现的(这是题目要求),这时应该用一对变量来保存
第一次出现的重复值,
比如(n没啥用)
4 n
23 5
46 25   (程序中用KEY和VALUE来保存他们)
46 32  (舍弃该对数值)
82 46  (应用82和46进行比较)
对着这个例子把我的程序走一遍就全懂了!就是这么简单,花了我一上午*/

import java.util.Scanner;
import java.util.ArrayList;

public class HW_47_线性插值 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            //二维数组存储键值对
            int[][] data=new int[n][2];
            for(int i=0;i<n;i++){
                data[i][0]=sc.nextInt();
                data[i][1]=sc.nextInt();
            }
            ArrayList<String> list=new ArrayList<String>();
            //若出现重复值,利用这两个变量存储前一个值,丢弃后出现的重复值(如题目要求)
            int KEY=data[0][0];
            int VALUE=data[0][1];
            list.add(KEY+" "+VALUE);
            for(int i=1;i<=n-1;i++){
                int diff=data[i][0]-KEY-1;
                if(diff>0){
                    for(int j=1;j<=diff;j++){
                        int key=KEY+j;
                        int value=VALUE+(data[i][1]-VALUE)/(data[i][0]-KEY)*j;
                        list.add(key+" "+value);
                    }
                    list.add(data[i][0]+" "+data[i][1]);
                    KEY=data[i][0];
                    VALUE=data[i][1];
                    //两个键相等则直接跳过,此时KEY,VVALUE保存的还是上一个值
                }else if(diff==-1)
                    continue;
                else{
                    list.add(data[i][0]+" "+data[i][1]);
                    KEY=data[i][0];
                    VALUE=data[i][1];
                }
            }
            for(String s:list)
                System.out.println(s);
        }
    }
}
