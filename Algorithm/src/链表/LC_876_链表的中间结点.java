package 链表;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LC_876_链表的中间结点 {

    /*数组*/
    public ListNode middleNode(ListNode head) {
        ArrayList arr = new ArrayList();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        int count = arr.size();
        return (ListNode) arr.get(count / 2);
    }

    /*快慢指针法*/
    public ListNode secondMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
