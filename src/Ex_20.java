import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，
 * 代表该深度上所有结点的值，请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class Ex_20 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        if (root == null || dep < 0) {
            return null;
        }

        ListNode res = new ListNode(-1);
        ListNode node = res;
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        current.add(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && dep != 1) {
            LinkedList<TreeNode> parent = current;
            current = new LinkedList<>();
            for (TreeNode t : parent) {
                if (t.left != null) {
                    current.add(t.left);
                }
                if (t.right != null) {
                    current.add(t.right);
                }
            }
            dep--;
        }
        for (TreeNode t : current) {
            node.next = new ListNode(t.val);
            node = node.next;
        }
        return res.next;
    }

}
