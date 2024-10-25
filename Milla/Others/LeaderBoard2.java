package Milla.Others;

import java.util.*;

public class LeaderBoard2 {
    /*
    * Users can refer each other to Robinhood. We want keep track of who is responsible for the most referrals and display the top users on a leaderboard.
    If user A refers user B, and user B refers user C. Then the leaderboard looks like this:
    Explanation: User B has 1 referral for referring user C. User A has 2 referrals because they referred user B,
    Given a list of referrals (Example Input: [ ["A","B"] , ["B", "C"] ], write a function that determines the leaderboard order.
    * return 값을 정렬한다는 거 까지 포함해서 구현해보기
    *
    * Edge cases
    * - What happen if there's a cycle A->B, B->A
    * - Should return the result as descending array?
    * - What if same person refer same person more than once -> count all of it, just count once?
    * - Should we care about lowercase letter in name of people?
    * - If someone hasn't refer anyone -> should I return as 0?
    * - If there no any recommendation -> should I return empty array?
    *
    * Plan
    * - represent the relationship between people as a graph
    * - traversal the graph using BFS
    * - Hashmap to store relationship
    * - calculate the total number of relationship on each person
    * - return the total number of each people as an array in descending order
    *
    * TC
    * O(V+E) V : number of people, E : relationship among people //다시체크
    * visit all node, all edge(relationship)
    *
    * SC
    * O(V+E) use hashmap to store every relationship.
    *
    *
    * */
    public static void main(String[] args) {
//        String from[] = {"A", "B", "C", "D", "E", "F"}; //만약 이형태로 고정이라면 굳이 맵을 안써도될듯하다.
//        String to[] = {"B", "C", "D", "E", "F", "G"};
        String from[] = {"A", "B", "C", "D", "E"}; //만약 이형태로 고정이라면 굳이 맵을 안써도될듯하다.
        String to[] = {"B", "C", "A", "D", "E"};


//        Recommender: ["A", "B", "C", "D", "E", "F"]
//        Recommended person: ["B", "C", "D", "E", "F", "G"]
/*
* {
"A": 5,
  "B": 5,
  "C": 5,
  "D": 4,
  "E": 4
* */
        Integer[] result = solution(from,to);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static Integer[] solution(String from[], String to[]){ //from {A,B,C} to {B,C,D}
        Map<String, List<String>> referrals = new HashMap<>();

        for (int i = 0; i < from.length; i++) {
            referrals.computeIfAbsent(from[i],t -> new ArrayList<>()).add(to[i]);
        }

        Integer[] result = new Integer[from.length];
        PriorityQueue<People> queue = new PriorityQueue<>(Comparator.comparing(a -> a.count));

        HashSet<String> set = new HashSet<>();

        for (String node : referrals.keySet()) {
            int count = bfs(referrals,node);
            System.out.println("---------------------");
            queue.add(new People(node,count));
        }

        //사람이름이랑 숫자를 같이 보여주려고 생각하면
//        Arrays.sort(result,Collections.reverseOrder()); //정렬하면 O(vLogV)
        return result;
    }

    static int bfs(Map<String, List<String>> referrals, String startNode){
        int total = 0;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList();
        queue.add(startNode); //queue : A
        set.add(startNode);

        while(!queue.isEmpty()){
            String curNode = queue.poll(); // poll D/ queue is empty
            if(!referrals.containsKey(curNode) || referrals.get(curNode).isEmpty()) continue;

            List<String> referralList = referrals.get(curNode);
            for (String node : referralList){
                if(!set.contains(node)) {
                    total++;
                    set.add(node);
                    queue.add(node); // Queue : D
                }
            }
        }
        System.out.println("total"+ startNode + ":" +total);
        return total; //4 A->B->C->D 4 -1 => 3
    }
      static class People{
        String name;
        int count;

        public People(String name, int count){
            this.name = name;
            this.count = count;
        }
    }
}
