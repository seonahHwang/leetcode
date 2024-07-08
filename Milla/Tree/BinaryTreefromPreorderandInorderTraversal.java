package Milla.Tree;

import java.util.Arrays;

public class BinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder1 = {1, 2, 3, 4};
        int[] inorder1 = {2, 1, 3, 4};
        TreeNode root1 = buildTree(preorder1, inorder1);
        printTree(root1);  // [1, 2, 3, null, null, null, 4]
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 기저 조건: 배열이 비어 있으면 null 반환
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 전위 순회의 첫 번째 요소는 트리의 루트 노드
        TreeNode root = new TreeNode(preorder[0]);

        // 루트 노드의 값을 중위 순회에서 찾아서 인덱스(mid)를 구함
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                System.out.println("root: "+inorder[i]);
                mid = i;
                break;
            }
        }

        // 왼쪽 서브트리의 전위 순회와 중위 순회 배열을 만듦
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        // 재귀적으로 왼쪽 서브트리를 빌드
        root.left = buildTree(leftPreorder, leftInorder);
        System.out.println("root.left"+root.left.val);

        // 오른쪽 서브트리의 전위 순회와 중위 순회 배열을 만듦
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        // 재귀적으로 오른쪽 서브트리를 빌드
        root.right = buildTree(rightPreorder, rightInorder);
        System.out.println("root.right"+root.right.val);

        // 트리의 루트 노드를 반환
        return root;
    }
}
