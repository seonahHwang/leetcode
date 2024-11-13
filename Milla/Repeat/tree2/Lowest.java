package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Lowest {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return root;
    }
}
