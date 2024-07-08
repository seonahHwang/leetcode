package Milla.Tree;

public class KthSmallestIntegerinBST {
    static int count = 0;
    static int result = 0;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4,new TreeNode(3,new TreeNode(2),null),new TreeNode(5));
        System.out.println(kthSmallest(node,4));
    }
    public static int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root,k);
        return result;
    }
    static void inorderTraversal(TreeNode node,int k){
        if(node == null) return;
        inorderTraversal(node.left,k);
        count++;
        if(count == k){
            result = node.val;
            return;
        }
        inorderTraversal(node.right,k);
    }
}
