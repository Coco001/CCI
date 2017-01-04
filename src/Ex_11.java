
/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Ex_11 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null) {
            return null;
        }

        ListNode smal = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode front = smal;
        ListNode behand = big;

        while (pHead != null) {
            if (pHead.val < x) {
                front.next = new ListNode(pHead.val);
                front = front.next;
            } else {
                behand.next = new ListNode(pHead.val);
                behand = behand.next;
            }
            pHead = pHead.next;
        }
        if (big.next == null) {
            return smal.next;
        }
        if (smal.next == null) {
            return big.next;
        }
        front.next = big.next;
        return smal.next;
    }

}
