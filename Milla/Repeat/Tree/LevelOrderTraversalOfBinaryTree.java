package Milla.Repeat.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversalOfBinaryTree {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root != null){
            q.add(root);
        }

        while (!q.isEmpty()){
           List<Integer> val = new ArrayList<>();

            for (int i = 0, len = q.size(); i < len; i++) {
                TreeNode node = q.poll();
                val.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(val);
        }
        return res;
    }
}
