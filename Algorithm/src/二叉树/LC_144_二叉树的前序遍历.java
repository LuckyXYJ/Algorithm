package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1、递归，list.add(节点)，递归左节点，右节点
 *      时间复杂度O(n)   空间复杂度O(n) 递归过程中有栈的开销
 * 2、迭代  从上到下，依次取左节点，把每个节点入栈，直到左节点为空。取栈顶节点又节点继续遍历
 *       时间复杂度O(n)   空间复杂度O(n)
 * 3、Morris 遍历
 */

public class LC_144_二叉树的前序遍历 {
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

    public LC_144_二叉树的前序遍历() {
        dataList = new ArrayList<>();
    }

    /**
     * 递归
     * @param root
     */
    public void preorderTraversal1(TreeNode root) {

        if (root == null) return;

        dataList.add(root.val);
        if (root.left != null) preorderTraversal(root.left);
        if (root.right != null) preorderTraversal(root.right);
    }

    /**
     * 迭代  等同于递归，维护一个stack
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
