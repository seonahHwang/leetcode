package Milla.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Brainstorm
* I'm going to approach using a BFS way. Because if we see the tree on the right side,
* and if the tree has only left node, It can be rightmost node.
* So I'll iterate over all nodes at each level and keep track of the last node processed,
* and It can help determine the rightmost node for each level.
*
* Plan
* Use a queue to help with the BFS traversal.
* For each level of the tree, I'll go through for loop to keep track of the last node in each level.
* When the for loop ends, last node is going to be rightmost node.
* And I'll add the value of the rightmost node to the result list.
* Repeat this process until all levels are processed.
*
* Edgecase
* If the tree is empty, Should I return null?
* If the tree has only one node, Should I return the node?
*
* TC : O(N) because each node is enqueued and dequeued exactly once.               ㅂ    11111111111111111111111111
* SC : O(N) because I'll use additional queue space.
*
* */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        //List to store the right side view of the tree
        List<Integer> res = new ArrayList<>();

        //Initialize queue for BFS traversal
        Queue<TreeNode> q = new LinkedList();

        //Start with the root node
        q.offer(root);

        //Continue until there are nodes to process
        while (!q.isEmpty()){
            TreeNode rightSide = null;
            int qlen = q.size();

            //go through each node at the current level
            for (int i = 0; i < qlen; i++) {
                TreeNode node = q.poll();

                //I need to check if the node is null, Since when we add to queue this node, we don't check if it's null.
                if(node != null){// 리프노드를 넣다보면 null일 수도 있어서
                    //Upgrade rightSide to the current node. Which means we can get the last rightside node in each level.
                    rightSide = node;
                    //add the left and right child both. because we can't guarantee which node going to be rightmost node now, so we just store both.
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            //And after loop this level, I store the rightmost node value to result list.
            if(rightSide != null){
                res.add(rightSide.val);
            }
        }
        return res;
    }

}
