package Milla.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNode {
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int n = indexes.size();
        int[] depth = new int[n+1];

        depth[1] = 1;
        queue.add(1);

        while (!queue.isEmpty()){
            int curr = (int)queue.poll();
            int left  = indexes.get(curr - 1).get(0);
            int right  = indexes.get(curr - 1).get(1);

            if(left != -1){
                depth[left] = depth[curr] + 1;
                queue.add(left);
            }
            if(right != -1){
                depth[right] = depth[curr] + 1;
                queue.add(right);
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            swap(indexes,queries.get(i), depth);
            List<Integer> subList = new LinkedList<>();
            inOrder(indexes,subList,1);
            result.add(subList);
        }
        return result;
     }

     public static void swap(List<List<Integer>> indexes, int k, int[] depth){
         for (int i = 1; i < depth.length; i++) {
             if(depth[i] %k == 0){
                 int temp = indexes.get(i - 1).get(0);
                 indexes.get(i-1).set(0,indexes.get(i-1).get(1));
                 indexes.get(i-1).set(1,temp);
             }
         }
     }

     public static void inOrder(List<List<Integer>> indexes, List<Integer> result, int node){
        if(node == -1) return;

        inOrder(indexes, result, indexes.get(node - 1).get(0));
        result.add(node);
        inOrder(indexes,result,indexes.get(node - 1).get(1));
     }
    public static void main(String[] args) {
        List<List<Integer>> indexes = new ArrayList<>();

        // 첫 번째 노드의 자식 노드 설정 (왼쪽 자식: 2, 오른쪽 자식: 3)
        List<Integer> node1 = new ArrayList<>();
        node1.add(2);  // 왼쪽 자식 노드
        node1.add(3);  // 오른쪽 자식 노드
        indexes.add(node1);

        // 두 번째 노드의 자식 노드 설정 (왼쪽 자식: null, 오른쪽 자식: null)
        List<Integer> node2 = new ArrayList<>();
        node2.add(-1); // 왼쪽 자식 노드
        node2.add(-1); // 오른쪽 자식 노드
        indexes.add(node2);

        // 세 번째 노드의 자식 노드 설정 (왼쪽 자식: null, 오른쪽 자식: null)
        List<Integer> node3 = new ArrayList<>();
        node3.add(-1); // 왼쪽 자식 노드
        node3.add(-1); // 오른쪽 자식 노드
        indexes.add(node3);
        List<Integer> queries = List.of(1, 1);

        List<List<Integer>> result = swapNodes(indexes, queries);

        for (List<Integer> traversal : result) {
            for (int node : traversal) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
