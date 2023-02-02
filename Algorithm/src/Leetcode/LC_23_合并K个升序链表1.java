package Leetcode;

import 链表.ListNode;

import java.util.PriorityQueue;

public class LC_23_合并K个升序链表1 {
    class Solution {
        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            public int compareTo(Status status2) {
                return this.val - status2.val;
            }
        }

        PriorityQueue<Status> queue = new PriorityQueue<Status>();

        public ListNode mergeKLists(ListNode[] lists) {
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(new Status(node.val, node));
                }
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (!queue.isEmpty()) {
                Status f = queue.poll();
                tail.next = f.ptr;
                tail = tail.next;
                if (f.ptr.next != null) {
                    queue.offer(new Status(f.ptr.next.val, f.ptr.next));
                }
            }
            return head.next;
        }
    }
}
