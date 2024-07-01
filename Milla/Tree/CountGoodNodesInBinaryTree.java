package Milla.Tree;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {

    }
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int max){
        if(root == null) return 0;
        int res = (root.val >= max) ? 1 : 0;
        max = Math.max(max, root.val);
        res += dfs(root.left, max);
        res += dfs(root.right, max);
        return res;
    }
}
