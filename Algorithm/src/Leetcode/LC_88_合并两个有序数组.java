package Leetcode;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class LC_88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ni = n - 1;
        int mi = m - 1;
        int ai = m + n - 1;
        while (ni >= 0) {
            if (mi >= 0 && nums1[mi] > nums2[ni]) {
                nums1[ai--] = nums1[mi--];
            }else {
                nums1[ai--] = nums2[ni--];
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        int i = m + n - 1;
        while(n > 0 || m > 0) {
            if(n == 0) return;
            if(m == 0) {
                nums1[i--] = nums2[--n];
                continue;
            }
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[i--] = nums1[--m];
            }else {
                nums1[i--] = nums2[--n];
            }
        }
    }
}
