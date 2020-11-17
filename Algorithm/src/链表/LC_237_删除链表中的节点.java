package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class LC_237_删除链表中的节点 {

    void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
