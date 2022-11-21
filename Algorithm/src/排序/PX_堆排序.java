package 排序;

import org.junit.Test;

public class PX_堆排序 {

    int[] array;
    int heapSize;

    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4,909,89};
        sort(nums);
        ArrayPrint.printlnArr(nums);
    }

    public void sort(int[] nums) {
        array = nums;
        heapSize = nums.length;
        for (int i = (heapSize >> 1)-1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize > 1) {
            swap(array, 0, --heapSize);
            siftDown(0);
        }
    }

    void siftDown(int index) {
        int element = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = array[childIndex];
            int rightIndex = childIndex + 1;
            if(rightIndex < heapSize && array[rightIndex] > child) {
                child = array[childIndex = rightIndex];
            }
            if (element > child) break;
            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }


    public void swap(int[] nums, int left, int right) {

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }
}
