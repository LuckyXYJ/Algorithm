package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1、递归，先左边，再加入当前节点val，再递归右边
 *      时间复杂度O(n)  空间复杂度O(n)
 * 2、
 */


public class LC_94_二叉树的中序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private ArrayList<Integer> dataList;

    public LC_94_二叉树的中序遍历() {
        dataList = new ArrayList<>();
    }

    public List<Integer> inorderTraversal1(TreeNode root) {


        test1(root);
        return dataList;
    }

    /**
     * 递归
     * @param root
     */
    public void test1(TreeNode root) {

        if (root == null) return;

        if (root.left != null) {
            test1(root.left);
        }
        dataList.add(root.val);
        if (root.right != null) {
            test1(root.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
