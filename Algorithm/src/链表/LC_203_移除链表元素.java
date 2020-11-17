package 链表;

public class LC_203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode newNode = new ListNode(0);
        ListNode currentNode = newNode;
        while (head != null) {
            if (head.val != val) {
                currentNode.next = head;
                currentNode = currentNode.next;
            }
            head = head.next;
        }
        currentNode.next = null;
        return newNode.next;
    }
}
