package 牛客网_华为;
import java.util.*;

public class HW_48_单向链表删除指定值得节点 {
    private ListNode head;

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public HW_48_单向链表删除指定值得节点(int val) {
        head = new ListNode(val);
    }

    public void insert(int val, int node) {
        ListNode p = head;
        while (p.val != node) {
            p = p.next;
        }
        ListNode newNode = new ListNode(val, p.next);
        p.next = newNode;
    }

    public void delete(int node) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null && p.next.val != node) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = dummy.next;
    }

    public ListNode head() {
        return this.head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int val = Integer.parseInt(in.next());
            HW_48_单向链表删除指定值得节点 solution = new HW_48_单向链表删除指定值得节点(val);
            for (int i = 1; i < n; i++) {
                val = Integer.parseInt(in.next());
                int node = Integer.parseInt(in.next());
                solution.insert(val, node);
            }
            val = Integer.parseInt(in.next());
            solution.delete(val);
            ListNode p = solution.head();
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }
}
