package Milla.Repeat.Tree;

public class DepthofBinaryTree {
    static int maxLen;
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
