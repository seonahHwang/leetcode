package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Balance {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{1,0}; //root가 비어있는 경우도 true로 return 되서 엣지케이스 해결!

        int left[] = dfs(root.left);
        int right[] = dfs(root.right);

        int height = Math.max(left[1], right[1]) + 1;
        int balanced = left[0] == 1 && right[0] == 1 && Math.abs(right[1] - left[1]) <= 1 ? 1 : 0;

        return new int[]{balanced, height};
    }
}
