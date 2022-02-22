package Leetcode;

public class LC_26_删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int k= 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
