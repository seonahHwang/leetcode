package Milla.Repeat.Tree;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int max){
        if(root == null) return 0;

        int res = root.val >= max ? 1 : 0; //같은 경우도 good노드!
        max = Math.max(root.val, max);

        res += dfs(root.left, max);
        res += dfs(root.right, max);

        return res;
    }
}
