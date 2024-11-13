package Milla.Repeat.Tree;

import java.util.Arrays;

public class BinaryTreefromPreorderAndInorder {
    public static void main(String[] args) {
        buildTree(new int[]{1,2,3,4}, new int[]{2,1,3,4});
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder.length == 0 || inorder.length == 0) return null;

       int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                mid = i;
            }
        }

        TreeNode root = new TreeNode(preorder[0]);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);

        root.left = buildTree(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);

        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}