package Milla.Repeat.Tree1;

public class BinaryTreeDiameter2 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1]; //0이 아니라 1
        dfs(root, res);
        return res[0];
    }
    public int dfs(TreeNode root, int[] res){
        if(root == null) return 0;

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);

        res[0] = Math.max(res[0], left+right); //현재 노드에서 지름 : left + right
        return 1 + Math.max(left, right);
    }
}