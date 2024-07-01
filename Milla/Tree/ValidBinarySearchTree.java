package Milla.Tree;

public class ValidBinarySearchTree {
    public static void main(String[] args) {


    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }

    public static boolean dfs(TreeNode root,double left,double right){
       if(root == null) return true;
       if(!(root.val > left && root.val < right)) return false;
       return dfs(root.left,left,root.val) && dfs(root.right, root.val , right);
    }
}
