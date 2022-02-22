package 二叉树;

public class LC_108_有序数组转二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return rangeToBST(nums, 0, nums.length - 1);
    }

    public TreeNode rangeToBST(int[] nums, int left, int right) {

        if(left > right) {
            return null;
        }
        int middle = (right + left)/2;
        TreeNode midNode = new TreeNode(nums[middle]);
        midNode.left = rangeToBST(nums, left, middle - 1);
        midNode.right = rangeToBST(nums, middle + 1, right);

        return midNode;
    }
}
