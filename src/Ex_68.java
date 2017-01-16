/**
 * 有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。
 * 请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现，链表的数据结构用ListNode实现。
 * 给定二叉查找树的根结点指针root，请返回转换成的链表的头指针。
 */
public class Ex_68 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ListNode listNode = new ListNode(-1);
    ListNode cur = listNode;
    public ListNode treeToList(TreeNode root) {
        // write code here
        inOrderTraverse(root);
        return listNode.next;
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        cur.next = new ListNode(node.val);
        cur = cur.next;
        inOrderTraverse(node.right);
    }
}
