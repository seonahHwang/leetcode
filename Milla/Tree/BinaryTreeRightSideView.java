package Milla.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();

        q.offer(root);

        while (!q.isEmpty()){
            TreeNode rightSide = null;
            int qlen = q.size();

            for (int i = 0; i < qlen; i++) {
                TreeNode node = q.poll();

                if(node != null){// 리프노드를 넣다보면 null일 수도 있어서
                    rightSide = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightSide != null){
                res.add(rightSide.val);
            }
        }
        return res;
    }

}
