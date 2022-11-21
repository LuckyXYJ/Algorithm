package Leetcode;


import 链表.ListNode;

public class LC_2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode p = res;
        int max = 0;
        while(l1!=null || l2!=null) {
            int v = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + max;
            max = v/10;
            p.next = new ListNode(v%10);
            p = p.next;

            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        if(max > 0) {
            p.next = new ListNode(max);
        }
        return res.next;
    }
}
