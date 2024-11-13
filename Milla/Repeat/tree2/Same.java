package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Same {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p!= null && q != null && p.val == q.val) {
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }
        else return false;
    }
}
