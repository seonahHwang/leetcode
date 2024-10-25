package Milla.Repeat.Tree;

import java.util.Map;

public class Balanced {

    static int res;
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{1,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int balanced = left[0] == 1 && right[0] == 1 && Math.abs(right[1] - left[0]) <= 1 ? 1 : 0;
        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{balanced, height};
    }
}
