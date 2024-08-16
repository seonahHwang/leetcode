package Milla.Repeat.Tree1;

import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int d = 10 - i;
            for (int j = 0; j < d; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//    public String[] solution(String[][] queries) {
////        if
//    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int qsize = q.size();
            TreeNode node = null;
            for (int i = 0; i < qsize; i++) {
                node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(node.val);
        }
        return ans;
    }
}
