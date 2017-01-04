/**
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class Ex_18 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBalance(TreeNode root) {
        // write code here
        if (getHeight(root) == -1) {
            return false;
        }
        return true;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        if (left == -1) {
            return -1;
        }
        int right = getHeight(node.right);
        if (right == -1) {
            return -1;
        }
        int dif = left - right;
        if (Math.abs(dif) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
