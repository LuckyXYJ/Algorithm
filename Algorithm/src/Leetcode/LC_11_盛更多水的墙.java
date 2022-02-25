package Leetcode;

public class LC_11_盛更多水的墙 {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int area = 0;
        while(l < r) {

            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));

            if(height[l] < height[r]) {
                l++;
            }else {
                r--;
            }

        }
        return area;
    }

    public int maxArea1(int[] height) {
        int max = 0;
        int l =0, r = height.length - 1;
        while (l < r) {
            int min = Math.min(height[l], height[r]);

            int temp = min * (r - l);

            max = Math.max(max, temp);

            // 快速跳过
            while (height[l] <= min && l < r) {
                ++l;
            }

            while (height[r] <= min && l < r) {
                --r;
            }
        }
        return max;
    }
}
