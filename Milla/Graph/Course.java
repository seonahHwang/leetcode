package Milla.Graph;

import java.util.*;

public class Course {
    public static void main(String[] args) {
        int a[][] = {{0,1},{0,2},{1,3},{1,4},{3,4},{4,1}};
        System.out.println(canFinish(5,a));

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }
        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i,preMap,visiting)) {
                return false;
            }
        }
        return true;
    }

    static boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visiting){
        System.out.println("course : "+course);
        if(visiting.contains(course)) {
            System.out.println("false course : "+course);
            return false;
        }
        if(preMap.get(course).isEmpty()) {
            System.out.println("true course : "+course);

            return true;
        }
        visiting.add(course);

        for (int pre : preMap.get(course)){
            if(!dfs(pre, preMap, visiting)){ //결과가 false 이면
                return false;
            }
        }
        visiting.remove(course); System.out.println("remove-- : "+course);
        preMap.put(course, new ArrayList<>()); // 이미 방문한 코스는 비워줌
        return true;
    }
}

