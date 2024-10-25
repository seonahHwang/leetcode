package Milla.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountConnectedComponent {
    public static void main(String[] args) {

        /*
        * Input:
        n=6
        edges=[[0,1], [1,2], [2,3], [4,5]]

        Output:
        2
        * */


    }
    public int countComponents(int n, int[][] edges) {
        int areaCnt = 0;
        int[][] adj = new int[n][n];
        boolean visit[] = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            int aNode = edges[i][0];
            int bNode = edges[i][1];
            adj[aNode][bNode] = 1;
            adj[bNode][aNode] = 1;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                bfs(adj, i, visit);
                areaCnt++;
            }
        }

        return areaCnt;
    }
    public void bfs(int[][] adj, int startNode, boolean[] visit){
        Queue<Integer> queue = new LinkedList();
        queue.add(startNode);

        while (!queue.isEmpty()){
            int node = queue.poll();

            for (int i = 0 ; i < adj.length ; i++){
                if(visit[i]) continue;
                if(adj[i][node] == 1 && adj[node][i] == 1) {
                    visit[i] = true;
                    queue.add(i);
                }
            }

        }
    }
}
