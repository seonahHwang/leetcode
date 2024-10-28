package Milla.Repeat.Tree;

public class SubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(subRoot == null) return true;

        if(isSame(root,subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;

        if(root != null && subRoot != null && root.val == subRoot.val){
            return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
        }
        return false;
    }
}
