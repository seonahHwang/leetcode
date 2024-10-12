package Milla.Graph;

import java.util.*;

public class RedundantConnection {
    public static void main(String[] args) {
//        Input: edges = [[1,2],[1,3],[3,4],[2,4]]
//        Output: [2,4]
        findRedundantConnection(new int[][]{{1,2},{1,3},{3,4},{2,4}});
    }
//    public static int[] findRedundantConnection(int[][] edges) {
//        Map<Integer,List<Integer>> adj = new HashMap<>();
//        int res[] = new int[2];
//
//        for (int i = 0 ; i < edges.length ; i++){
//          adj.computeIfAbsent(edges[i][0],t -> new ArrayList<>()).add(edges[i][1]);
//          adj.computeIfAbsent(edges[i][1],t -> new ArrayList<>()).add(edges[i][0]);
//        }
//        return res;
//    }
//    static boolean bfs(Map<Integer,List<Integer>> adj){
//
//    }

    public static int[] findRedundantConnection(int[][] edges) {
        int res[] = new int[2];
        int maxN = 0;

        for (int i = 0; i < edges.length; i++) {
            maxN = Math.max(edges[i][0],maxN);
            maxN = Math.max(edges[i][1],maxN);
        }

        int[][] adj = new int[maxN+1][maxN+1];

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = 0;
            adj[edges[i][1]][edges[i][0]] = 0;
            if(bfs(adj)){
                System.out.println("///");
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }

        return res;
    }
    static boolean bfs(int[][] adj){
        Queue<Integer> q = new LinkedList();
        boolean[] v = new boolean[adj.length];

        int len = 0;
        q.add(1);

        while (!q.isEmpty()){
            int n = q.poll();

            for (int i = 1; i < adj.length; i++) {
                if(!v[i] && adj[i][n] == 1 && adj[n][i] == 1){
                    System.out.println("n: "+n + ", i:"+i);
                    len++;
                    v[i] = true;
                    q.add(i);
                }
            }
        }

        System.out.println(len+","+(adj.length-1));
        if(len == adj.length - 1) return true;
        else return false;
    }
}
