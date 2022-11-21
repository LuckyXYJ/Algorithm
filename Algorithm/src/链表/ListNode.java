package 链表;

import java.util.Objects;
import java.util.Optional;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        val = 0;
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(val).append("->");
        ListNode node = next;
        while (node != null) {
            stringBuffer.append(node.val);
            Optional.ofNullable(node.next).ifPresent(n -> stringBuffer.append("->"));

            node = node.next;
        }
        return stringBuffer.toString();
    }

    public static ListNode create(int... val) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i : val) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;

    }
}
