package Milla.Repeat.Tree1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            for (int i = 0; i < size ; i++){
                TreeNode node = q.poll();
                sub.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(sub);
        }
        return ans;
    }
}
