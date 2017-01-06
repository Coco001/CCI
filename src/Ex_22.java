import java.util.ArrayList;

/**
 * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 * 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
 * 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1
 */
public class Ex_22 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private ArrayList<TreeNode> list;
    public int findSucc(TreeNode root, int p) {
        // write code here
        list = new ArrayList<>();
        preOrder(root, list);
        boolean flag = false;
        for (TreeNode node : list) {
            if (flag) {
                return node.val;
            }
            if (node.val == p) {
                flag = true;
            }
        }
        return -1;
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
