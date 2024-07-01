package Milla.Tree;

/*
* Let's start by understanding the problem. We need to find the lowest common ancestor of two given nodes, p and q, in a binary search Tree.
*
* We can take advantage of the properties of a BST. In a BST, the left child is always less than the parent node,
* and the right child is always greater than the parent node. So I'll use this property to solve it.
*
* I'd like to check the edge case
* If the tree might be empty, should I return null?
*
* Here's the plan.
* Plan
* 1. Start from the root of the BST.
* 2. Compare the values of p and q with the current node.
* 3.If both p and q are less than the current node, move to the left child.
4. If both p and q are greater than the current node, I'll move to the right child.
5. If one of p or q is on one side and the other is on the opposite side, or one of them is equal to the current node, then the current node is the LCA.
6. Continue this process until the LCA is found.
*
* TC : O(h) h is the height of the BST.
* SC : O(1) since we only use a constant amount of extra space.
* */
public class LowestCommonAncestorinBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Traverse the tree until we find the LCA
        while (root != null){
            // If both p and q are less than the current node, move to the left child
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than the current node, move to the right child
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If one of p or q is on one side and the other is on the opposite side, or one of them is equal to the current node,
            // then the current node is the LCA
            else return root;
        }
        //// If no LCA is found, return null.
        return null;
    }
}
