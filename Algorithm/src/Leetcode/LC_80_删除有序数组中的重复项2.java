package Leetcode;

//1,1,1,2,2,3   3
//1,1,2,2,2,3
//1,1,2,2,1,3
//1,1,2,

public class LC_80_删除有序数组中的重复项2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int k = 2;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
