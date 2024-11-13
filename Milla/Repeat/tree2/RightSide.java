package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSide {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList();
        if(root != null) q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(node.val);
        }
        return res;
    }
}
