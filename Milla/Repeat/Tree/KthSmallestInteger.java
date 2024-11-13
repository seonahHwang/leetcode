package Milla.Repeat.Tree;

public class KthSmallestInteger {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        dfs(root, k, tmp);
        return tmp[1];
    }

    public void dfs(TreeNode root, int k, int[] tmp){
        if(root == null) return;

        dfs(root.left, k, tmp);

        tmp[0] += 1;
        if(tmp[0] == k){
            tmp[1] = root.val;
        }

        dfs(root.right, k, tmp);
    }
}
