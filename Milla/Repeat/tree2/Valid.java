package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Valid {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, -1000, 1000);
    }
    public boolean dfs(TreeNode root, int left, int right){
        if(root == null) return true;
        if(!(root.val > left && root.val < right)) return false;
        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }
}
