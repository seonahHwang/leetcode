package Milla.Repeat.Tree1;

public class BinaryTreeDiameter {
    public static void main(String[] args) {

    }
    public static int diameterOfBinaryTree(TreeNode root) {
        int res[] = new int[1];
        dfs(root,res);
        return res[0];
    }

    private static int dfs(TreeNode root, int[] res) {
        if(root == null) return 0;

        int left = dfs(root.left,res);
        int right = dfs(root.right,res);
        res[0] = Math.max(res[0],left+right);
        return 1 + Math.max(left,right);
    }

}
