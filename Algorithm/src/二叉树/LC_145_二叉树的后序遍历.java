package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1、递归， 左  -->   右  -->   根
 *
 */

public class LC_145_二叉树的后序遍历 {
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

    public List<Integer> postorderTraversal(TreeNode root) {

        dataList = new ArrayList<Integer>();
        test1(root);
        return dataList;
    }

    public void test1 (TreeNode root){

        if (root == null) return;

        if (root.left != null) {
            test1(root.left);
        }

        if (root.right != null) {
            test1(root.right);
        }
        dataList.add(root.val);
    }

    /**
     * 迭代方式
     * @param root
     * @return
     */
    public List<Integer> diedai(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
