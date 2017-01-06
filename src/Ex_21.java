import java.util.ArrayList;

/**
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 * 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
public class Ex_21 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<TreeNode> list;
    //二叉树的中序遍历满足递增
    public boolean checkBST(TreeNode root) {
        // write code here
        list = new ArrayList<>();
        preOrder(root, list);
        int pre = Integer.MIN_VALUE;
        int cur = 0;
        for (TreeNode node : list) {
            cur = node.val;
            if (cur <= pre) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

    private void preOrder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }
        preOrder(node.left, list);
        list.add(node);
        preOrder(node.right, list);
    }
}
