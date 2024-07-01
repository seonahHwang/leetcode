package Milla.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* brainstorm
* We need to traversal the every tree node in the tree.
* So I'm going to approach it with BFS way.
* I can get sublist in each level by using a queue. The queue will keep track of nodes at the current level and process them one by one,
* And add their children to the queue for the next level.
*
* Plan
* Check if the root is null. If it is, return an empty list.
* Continue while loop until queue is empty which means we'll do traversal all nodes.
*  - Create a sublist to store the values of nodes at the current level.
*  - Get the number of nodes at the current level
*  - Process each node at the current level.
*
* * Edgecase
 * If the tree is empty, Should I return null?
 * If the tree has only one node, Should I return the node?
 *
 * TC : O(N) Let's say n is the number of nodes in the tree. I'll go through each node exactly once. that's why the TC is O(N)
 * SC : O(N) Let's talk about the space complexity, I'm going to use queue for tracking as much as N. So It's going to be O(N)
* */
public class LevelOrderTraversalOfBinaryTree {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //It's one of edge case. As I said, If the root is null, return an empty list.
        if (root == null) return new LinkedList<>();

        //Initialize list to store the result
        List<List<Integer>> result = new LinkedList<>();

        //Initialize queue for BFS travelsal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //Go through every node
        while (!queue.isEmpty()){
            List<Integer> subList = new LinkedList<>(); //Initialize sublist for storing node in each level.
            int size = queue.size();

            //I'll go through for loop to get nodes in each level.
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                subList.add(currentNode.val);

                //Store left and right node for next level.
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }

            //After finishing for loop which means end of one level,I'll add sublist to result list.
            result.add(subList);
        }

        //return
        return result;
    }
}
