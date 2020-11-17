package 牛客网_华为;

//利用头插法将输入链表倒序，然后寻找第K个节点，注意下表从0开始，所以<k
import java.util.*;
class ListNode{
    public int val;
    public ListNode pNext;
}

public class HW_51_输出单向链表中倒数第k个结点 {
    public static ListNode FinfKthToTail(ListNode head, int k){
        int i = 0;
        while(head.pNext != null && i < k){
            head = head.pNext;
            i++;
        }
        return head;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            ListNode head = new ListNode();
            head.pNext = null;
            for(int i = 0; i < n; i++){
                ListNode p = new ListNode();
                p.pNext = head.pNext;
                p.val = in.nextInt();
                head.pNext = p;
            }
            int k = in.nextInt();
            ListNode kthNode = FinfKthToTail(head, k);
            System.out.println(kthNode.val);
        }
        in.close();
    }
}
