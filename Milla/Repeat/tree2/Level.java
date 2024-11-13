package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                subList.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(subList);
        }

        return res;
    }
}
