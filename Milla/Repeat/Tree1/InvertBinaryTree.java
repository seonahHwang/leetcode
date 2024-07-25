package Milla.Repeat.Tree1;

public class InvertBinaryTree {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfs(root.left);
        dfs(root.right);
    }
}
