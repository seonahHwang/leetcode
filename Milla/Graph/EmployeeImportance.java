package Milla.Graph;

import java.util.*;

public class EmployeeImportance {
    public static void main(String[] args) {

    // [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1

        /*
        * employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
        * */
//        List<Employee> list = new ArrayList<>();
//        Employee e1 = new Employee(1,5,Arrays.asList(2,3));
//        Employee e2 = new Employee(2,3,Arrays.asList(2,3));
//        Employee e3 = new Employee(3,3,new ArrayList<>());
//        list.add(e1);
//        list.add(e2);
//        list.add(e3);
//
//        System.out.println(getImportance(list, 1));

    }
    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();

        int curId = 0;
        for (Employee employee : employees){
            curId = employee.id;
            adjMap.put(curId, new ArrayList(employee.subordinates));
        }
        return bfs(adjMap, id);
    }

    public static int bfs(Map<Integer,List<Integer>> adjMap, int startId){
//        int totalImportance = 0;
//        Queue<Employee> queue = new LinkedList<>();
//
//        queue.add(startId);
//
//        while (!queue.isEmpty()){
//            Employee curNode = queue.poll();
//            System.out.println("curNode: "+curNode);
//            totalImportance += curNode.importance;
//            for (int i = 0; i < adjMap.get(curNode).size() ; i++){
//                int nextNode = adjMap.get(curNode).get(i);
//                queue.add(nextNode);
//            }
//        }
//        return totalImportance;
        return 0;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        Employee(int id, int importance, List<Integer> subordinates){
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };
}
