package 链表;

public class LC_83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) head.next = head.next.next;
            else head = head.next;
        }
        return first;
    }
}
