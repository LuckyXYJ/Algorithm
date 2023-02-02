package 排序;

import org.junit.Test;

//7,6,5,4,3,2,1
//1,5,6,4,3,2,7
//

public class PX_快排 {

    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4};
//        sort(nums);
        quickSort(nums, 0, nums.length);
        ArrayPrint.printlnArr(nums);
    }

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length);
    }

    public void quickSort(int[] nums, int left, int right) {

        if (right - left < 2) return;
        int p = partition(nums, left, right);
        quickSort(nums, left, p);
        quickSort(nums, p + 1, right);
    }

    public int partition(int[] nums, int left, int right) {

        swap(nums, left, left + (int)(Math.random() * (right - left)));

        int temp = nums[left];
        right --;

        while (left < right) {

            while (left < right) {

                if (temp < nums[right]) {
                    right --;
                }else {
                    nums[left++] = nums[right];
                    break;
                }
            }

            while (left < right) {
                if (temp > nums[left]) {
                    left ++;
                }else {
                    nums[right--] = nums[left];
                    break;
                }
            }
        }
        nums[left] = temp;
        return left;
    }

    public void swap(int[] nums, int left, int right) {

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }
}
