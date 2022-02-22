package Leetcode;

public class LC_75_颜色分类 {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        int left = 0, right = nums.length - 1;
        for(int i = 0; i <= right; i++) {
            if(nums[i] == 0) {
                // nums[left++] = nums[i--];
//                if(i != left) {
                    swap(nums,left++, i);
//                }
            }else if (nums[i] == 2) {
                // nums[right--] = nums[i--];
//                if(i != right) {
                    swap(nums, right--, i--);
//                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
