package Leetcode;

public class LC_2319_判断矩阵是否是一个X矩阵 {

    public boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length ; i++) {
            int[] items = grid[i];
            for (int j = 0; j < items.length; j++) {
                if ((j == i || j == items.length - 1 - i) && items[j] == 0) {
                    return false;
                }
                if ((j != i && j != items.length - 1 - i) && items[j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
