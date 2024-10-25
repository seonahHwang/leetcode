package Milla.Graph;

import java.util.*;

public class AllPath {
    public static void main(String[] args) {
        int a[][] = {{1,2},{3},{3},{}};
        allPathsSourceTarget(a);
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>  result = new ArrayList<>();
        Map<Integer,List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < graph.length; i++) { //O(V+E)
            for (int j = 0; j < graph[i].length; j++) {
                System.out.println("i:"+i);
                adjMap.computeIfAbsent(i,t -> new ArrayList<>()).add(graph[i][j]);
            }
            if(graph[i].length == 0) adjMap.put(i, new ArrayList<>());
        }

        List<Integer> paths = new ArrayList<>();
        paths.add(0);

        dfs(adjMap, 0, paths, result);
        return result;
    }
    public static void dfs(Map<Integer,List<Integer>> adjMap, int currNode,  List<Integer> paths, List<List<Integer>> result){
        if(currNode == adjMap.size()-1) {
            result.add(new ArrayList(paths));
            return;
        }

        if(!adjMap.get(currNode).isEmpty()){
            for(int node : adjMap.get(currNode)){
                paths.add(node);
                dfs(adjMap,node,paths,result);
                paths.remove(paths.size()-1);
            }
        }
    }
}