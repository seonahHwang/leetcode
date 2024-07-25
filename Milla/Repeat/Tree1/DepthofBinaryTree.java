package Milla.Repeat.Tree1;

public class DepthofBinaryTree {
    static int max;
    public int maxDepth(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root,0);
        return max;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null) {
            max = Math.max(depth,max);
            return;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
