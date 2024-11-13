package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class SubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root == null) return false;
       if(subRoot == null) return true;

       if(isSameTree(root, subRoot)) return true; //그저 두 노드가 같은지를 확인하고 그 값을 return
       return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); //재귀적으로 확인하기 위해서 계속 간다. 두개중에 하나만 같으면 됨!
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;

        if(root != null && subRoot != null && root.val == subRoot.val){
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
        else return false;
    }
}
