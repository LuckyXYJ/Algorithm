package Leetcode;

public class LC_167_两数之和 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while(l < r) {
            if(numbers[l] + numbers[r] > target) {
                r--;
            }else if(numbers[l] + numbers[r] < target) {
                l++;
            }else {
                // return new int[] {l, r};
                break;
            }
        }
        return new int[] {l+1, r+1};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[low] + numbers[mid] > target) {
                high = mid - 1;
            } else if (numbers[mid] + numbers[high] < target) {
                low = mid + 1;
            } else if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                return new int[]{low + 1, high + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
