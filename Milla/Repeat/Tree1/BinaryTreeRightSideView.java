package Milla.Repeat.Tree1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }
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
