package Leetcode;

import org.junit.Test;

public class LC_215_数组中的第K个最大元素 {

    @Test
    public void test() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1, k);

        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int l, int r, int k) {

        if(l >= r) return;
        int p = partition(nums, l, r);

        if(nums.length - k > p) {
            quickSort(nums, p + 1, r, k);
        }else if(nums.length - k < p){
            quickSort(nums, l, p - 1, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int p = l;
        for(int i = l + 1; i <= r; i++) {
            if(nums[i] < nums[l]) {
                swap(nums, i, ++p);
            }
        }
        swap(nums, l, p);
        return p;
    }

    public void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
