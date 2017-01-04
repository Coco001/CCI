/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Ex_09 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //思路：定义连个指针，快指针先走到第k个节点，然后快慢指针一起移动，当快指针到达链表末尾时慢指针所指就是所求
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        if (fast == null) {
            return null;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
