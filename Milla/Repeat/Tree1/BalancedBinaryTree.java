package Milla.Repeat.Tree1;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    public static int[] dfs(TreeNode root){
        if (root == null) return new int[]{1,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1]-right[1]) <= 1;
        int height = Math.max(left[1],right[1]);

        return new int[]{balanced ? 1 : 0 , height};
    }
}
