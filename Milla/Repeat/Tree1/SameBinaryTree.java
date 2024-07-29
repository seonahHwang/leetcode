package Milla.Repeat.Tree1;

public class SameBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    public boolean dfs(TreeNode p, TreeNode q){
        if(q == null && p == null) return true;
        if(q != null && p != null && q.val == p.val){
            return dfs(p.left, q.left) && dfs(p.right, q.right);
        }
        else return false;
    }
}
