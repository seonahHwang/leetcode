package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Depth {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
