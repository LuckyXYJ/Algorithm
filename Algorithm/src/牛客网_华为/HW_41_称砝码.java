package 牛客网_华为;

import java.util.*;

public class HW_41_称砝码 {
    public static int fama(int n, int[] weight, int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i <= nums[0]; i++){
            set.add(weight[0] * i);
        }
        for(int i = 1; i < n; i++){
            List<Integer> list = new ArrayList<Integer>(set);
            for(int j = 0; j <= nums[i]; j++){
                for(int k = 0; k < list.size(); k++){
                    set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] weight = new int[n];
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                weight[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            System.out.println(fama(n, weight, nums));
        }
        in.close();
    }
}
