package Milla.Repeat.Tree1;

public class DepthofBinaryTree {
    static int max;
    public int maxDepth(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root,0);
        return max;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null) {
            max = Math.max(depth,max);
            return;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }

    public static int height(TreeNode root) {
        if (root == null) { // 기본 케이스
            System.out.println("//// return");
            return 0;
        } else { // 재귀적 케이스
            System.out.println("호출 root.val : "+root.val);
            int leftHeight = height(root.left);
            System.out.println("leftheight : " + leftHeight);
//            System.out.println("right 호출 차례 root.right : "+root.right);
            int rightHeight = height(root.right);
            System.out.println("높이계산 root : "+root.val + " rightHeight " + rightHeight);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3));
        height(node);
    }
}