package Leetcode;

public class LC_27_移除元素 {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i]!=val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
