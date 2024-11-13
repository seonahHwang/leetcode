package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Good {
    int res; //전역변수
    public int goodNodes(TreeNode root) {
        res = 0;
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    public void dfs(TreeNode root, int max){ //max는 지역변수, return은 void
        if(root == null) return;

        if(max <= root.val) {
            max = root.val;
            res++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
