package 牛客网_华为;

import java.util.Scanner;

/**
 * 自动售货系统
 * @author Administrator
 *
 */
public class HW_98_自动售货系统{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            doString(s);
        }
        sc.close();
    }
    public static void doString(String input){
        String[] arr = input.split(";");
        String initial = arr[0];
        Goods goods = OpReset(initial);
        for(int i=1;i<arr.length;i++){
            String temp = arr[i];
            String[] temp2 = temp.split(" ");
            if(temp2[0].equals("p")){
                goods = OpPay(temp,goods);
            }else if(temp2[0].equals("b")){
                goods = OpBuy(temp,goods);
            }else if(temp2[0].equals("c")){
                goods = OpChange(temp,goods);
            }else if(temp2[0].equals("q")||temp2[0].matches("q\\d")){
                OpQuery(temp,goods);
            }

        }

    }
    public static Goods OpReset(String initial){//初始化
        String[] arr = initial.split(" ");
        String[] Asome = arr[1].split("-");
        String[] Moneysome = arr[2].split("-");
        int[] A = new int[Asome.length];
        int[] B = new int[Moneysome.length];
        for(int i=0;i<Asome.length;i++){
            A[i]=Integer.valueOf(Asome[i]);
        }
        for(int i=0;i<Moneysome.length;i++){
            B[i]=Integer.valueOf(Moneysome[i]);
        }
        Goods goods = new Goods(A,B,0);
        System.out.println("S001:Initialization is successful");
        return goods;
    }
    public static Goods OpPay(String payString,Goods goods){//投币
        String[] arr = payString.split(" ");
        int payNum = Integer.valueOf(arr[1]);
        if(payNum!=1&&payNum!=2&&payNum!=5&&payNum!=10){
            System.out.println("E002:Denomination error");
            return goods;
        }
        else if((payNum==5||payNum==10)&&(goods.num_coin[0]*1+goods.num_coin[1]*2<payNum)){
            System.out.println("E003:Change is not enough, pay fail");
            return goods;
        }
        else if(payNum>10){
            System.out.println("E004:Pay the balance is beyond the scope biggest");
            return goods;
        }
        else if(goods.num_goods[0]==0&&goods.num_goods[1]==0&&goods.num_goods[2]==0&&goods.num_goods[3]==0&&goods.num_goods[4]==0&&goods.num_goods[5]==0){
            System.out.println("E005:All the goods sold out");
            return goods;
        }
        else{
            switch(payNum){
                case 1:goods.num_coin[0]++;break;
                case 2:goods.num_coin[1]++;break;
                case 5:goods.num_coin[2]++;break;
                case 10:goods.num_coin[3]++;break;
            }
            int tmp = payNum + goods.toubi_yu_e;
            goods.toubi_yu_e += payNum;
            System.out.println("S002:Pay success,balance="+tmp);
            return goods;
        }

    }
    public static Goods OpBuy(String buyString,Goods goods){//购买商品
        String[] goodsString = {"A1","A2","A3","A4","A5","A6"};
        String[] arr = buyString.split(" ");
        String buy = arr[1];
        int price = 0;
        int index = 10;
        for(int i=0;i<goodsString.length;i++){
            if(buy.equals(goodsString[i])){
                switch(i){
                    case 0:price = 2;index=i;break;
                    case 1:price = 3;index=i;break;
                    case 2:price = 4;index=i;break;
                    case 3:price = 5;index=i;break;
                    case 4:price = 8;index=i;break;
                    case 5:price = 6;index=i;break;
                }

            }
        }
        if(index==10){
            System.out.println("E006:Goods does not exist");
            return goods;
        }
        else if(goods.toubi_yu_e<price){
            System.out.println("E008:Lack of balance");
            return goods;
        }
        else if(goods.num_goods[index]==0){
            System.out.println("E007:The goods sold out");
            return goods;
        }
        else{
            goods.toubi_yu_e=goods.toubi_yu_e-price;
            System.out.println("S003:Buy success,balance="+goods.toubi_yu_e);
            return goods;
        }
    }
    public static Goods OpChange(String changeString,Goods goods){//退币
        if(goods.toubi_yu_e==0){
            System.out.print("E009:Work failure");
            return goods;
        }else{
            int tuibi = goods.toubi_yu_e;
            int num_shi = tuibi/10;

            if(goods.num_coin[3]-num_shi<0){
                num_shi = goods.num_coin[3];
            }
            int num_wu = (tuibi-10*num_shi)/5;
            if(goods.num_coin[2]-num_wu<0){
                num_wu = goods.num_coin[2];
            }
            int num_er = (tuibi-10*num_shi-5*num_wu)/2;
            if(goods.num_coin[1]-num_er<0){
                num_er = goods.num_coin[1];
            }
            int num_yi = (tuibi-10*num_shi-5*num_wu-2*num_er)/1;
            if(goods.num_coin[0]-num_yi<0){
                num_yi = goods.num_coin[0];
            }
            goods.num_coin[3] = goods.num_coin[3]-num_shi;
            goods.num_coin[0] = goods.num_coin[0]-num_yi;
            goods.num_coin[1] = goods.num_coin[1]-num_er;
            goods.num_coin[2] = goods.num_coin[2]-num_wu;

            goods.toubi_yu_e=0;
            System.out.println("1 yuan coin number="+num_yi);
            System.out.println("2 yuan coin number="+num_er);
            System.out.println("5 yuan coin number="+num_wu);
            System.out.println("10 yuan coin number="+num_shi);
            return goods;
        }
    }
    public static void OpQuery(String queryString,Goods goods){
        String[] arr = queryString.split(" ");
        String query = "";
        if(arr.length==2){
            query = arr[1];
        }
        else{
            System.out.print("E010:Parameter error");
        }
        if(query.equals("0")){
            System.out.println("A1 "+"2 "+goods.num_goods[0]);
            System.out.println("A2 "+"3 "+goods.num_goods[1]);
            System.out.println("A3 "+"4 "+goods.num_goods[2]);
            System.out.println("A4 "+"5 "+goods.num_goods[3]);
            System.out.println("A5 "+"6 "+goods.num_goods[4]);
            System.out.println("A6 "+"7 "+goods.num_goods[5]);
        }else if(query.equals("1")){
            System.out.println("1 yuan coin number="+goods.num_coin[0]);
            System.out.println("2 yuan coin number="+goods.num_coin[1]);
            System.out.println("5 yuan coin number="+goods.num_coin[2]);
            System.out.println("10 yuan coin number="+goods.num_coin[3]);
        }
    }
}
class Goods{
    int[] num_goods = new int[6];
    int[] num_coin = new int[4];
    int toubi_yu_e;
    public Goods(int[] num_goods,int[] num_coin,int toubi_yu_e){
        this.num_goods = num_goods;
        this.num_coin = num_coin;
        this.toubi_yu_e = toubi_yu_e;
    }

}

