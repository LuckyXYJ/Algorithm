package Leetcode;

import org.junit.Test;

public class LC_41_缺失的第一个正数 {

    @Test
    public void test() {
        int[] nums = new int[]{3,4,-1,1};

        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int i = 0;
        while(i < nums.length) {
            int temp = nums[i];
            if(temp >= 0 && temp < nums.length && temp != nums[temp]){
                nums[i] = nums[temp];
                nums[temp] = temp;
            }else {
                i ++;
            }
        }

        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != j) {
                return j;
            }
        }
        return nums[0] == nums.length?nums.length + 1:nums.length;
    }
}
