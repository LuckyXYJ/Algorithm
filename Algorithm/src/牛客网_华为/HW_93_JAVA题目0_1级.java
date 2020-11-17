package 牛客网_华为;

//参考网友ld1230的解法
//思想：将能整除3或者5的各自分为一组，记为sum1和sum2，剩余的保存在数组nums里
//现有两组，剩余nums里的数要么在sum1里要么在sum2里，利用递归依次放在sum1和sum2中
//最终nums里的数字全部放进去，若sum1 == sum2，则返回true，否则，返回false
import java.util.Scanner;
public class HW_93_JAVA题目0_1级 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int index = 0,sum1 = 0,sum2 = 0;
            for(int i=0;i<n;i++){
                int tmp = scanner.nextInt();
                if(tmp % 5 == 0) sum1 += tmp;
                else if (tmp % 3 == 0) sum2 += tmp;
                else nums[index++] = tmp;
            }
            System.out.println(isExists(sum1, sum2, nums, 0));
        }
        scanner.close();
    }
    public static boolean isExists(int sum1,int sum2,int[] nums,int index){
        if(index == nums.length && sum1 != sum2) return false;
        if(index == nums.length && sum1 == sum2) return true;
        if(index < nums.length) return isExists(sum1+nums[index], sum2, nums, index+1) || isExists(sum1, sum2+nums[index], nums, index+1);
        return false;
    }
}
