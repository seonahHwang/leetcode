package Milla.Repeat.tree2;

import Milla.Tree.TreeNode;

public class Kth {
    int cnt;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        res = 0;
        dfs(root, k);
        return res;
    }
    public void dfs(TreeNode root, int k){
        if(root == null) return;

        dfs(root.left, k);
        cnt++;
        if(cnt == k){ //inorder순회와 같이 중간에 있어야 inorder 순서대로 답을 구할 수 있음 
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}