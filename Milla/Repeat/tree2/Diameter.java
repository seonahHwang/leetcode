package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Diameter {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right); //지름

        return Math.max(left, right) + 1; //높이구하기
    }
}
