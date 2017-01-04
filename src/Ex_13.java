import java.util.Stack;

/**
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Ex_13 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = pHead;
        ListNode slow = pHead;
        stack.push(slow);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow);
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != slow.val) {
                return false;
            } else {
                slow = slow.next;
            }
        }
        return true;
    }
}
