package Milla.Repeat.Tree1;

public class LCA2 {
    /**
     * Approach
     * BST인점을 활용해서 (이미 정렬이 되어있으므로) DFS로 탐색하면서 root 와 p,q값을 비교하고
     * 값에 따라 왼쪽으로 갈지 오른쪽으로 갈지를 정하면 된다.
     *
     * Edge cases
     * tree가 비어있는 경우 -> return null
     * tree의 노드가 하나인 경우 -> return root
     *
     * TC
     *
     * SC
     */

    public static void main(String[] args) {
/*
* root=[5,3,8,1,4,7,9,null,2]
p=1
q=2*/
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if(p.val > root.val && q.val > root.val) root = root.left;
            else if(p.val < root.val && q.val < root.val) root = root.right;
            else return root;
        }
    }
}