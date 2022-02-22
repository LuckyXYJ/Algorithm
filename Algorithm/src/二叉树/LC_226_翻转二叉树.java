package 二叉树;

//import com.sun.deploy.panel.ITreeNode;

import java.util.LinkedList;

/**
 * 1、递归交换左右
 * 2、节点加入队列，逐步交换
 */

public class LC_226_翻转二叉树 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {

        if(root == null) return null;


        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.push(node.left);
            }
            if (node.right != null) {
                queue.push(node.right);
            }
        }
        return root;
    }


}
