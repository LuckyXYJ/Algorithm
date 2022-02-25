package 排序;

import org.junit.Test;

//7,6,5,4,3,2,1
//1,5,6,4,3,2,7
//

public class PX_快排 {

    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4};
        sort(nums);
        ArrayPrint.printlnArr(nums);
    }

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {

        if (left >= right) return;
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    public int partition(int[] nums, int left, int right) {

        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);

        return j;
    }

    public void swap(int[] nums, int left, int right) {

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];

//        nums[left] = nums[left]^nums[right];
//        nums[right] = nums[left]^nums[right];
//        nums[left] = nums[left]^nums[right];
    }
}
