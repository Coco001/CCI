/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
 * 也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 * 测试样例：
 * {1,2,3},{3,2,1}
 * 返回：{4,4,4}
 */
public class Ex_12 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode res = new ListNode(-1);
        ListNode cur = res;

        int add = 0;
        int val;
        while (a != null || b != null) {
            if (a == null) {
                val = add + b.val;
                b = b.next;
            } else if (b == null) {
                val = add + a.val;
                a = a.next;
            } else {
                val = a.val + b.val + add;
                a = a.next;
                b = b.next;
            }
            cur.next = new ListNode(val % 10);
            add = val / 10;
            cur = cur.next;
        }
        if (add != 0) {
            cur.next = new ListNode(add);
        }
        return res.next;
    }

}
