package Milla.Repeat.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }

    public List<Integer> bfs(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        if(root != null) q.add(root);


        while (!q.isEmpty()){
            TreeNode node = null;
            for (int i = 0, len = q.size(); i < len; i++) {
                node = q.poll();

                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }
}
