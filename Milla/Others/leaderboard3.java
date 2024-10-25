package Milla.Others;

import java.util.*;

public class leaderboard3 {
    public static void main(String[] args) {
//        String[] f = {"A","B","C","F"}; //a->b->c->d
//        String[] t = {"B","C","D","B"};

        String[] array1 = {"A", "B", "C", "C"};
        String[] array2 = {"F", "C", "D", "E"};
        solution(array1,array2);
    }

    static void solution(String[] from, String[] to){
        Map<String, List<String>> referralMap = new HashMap<>();
        Map<String, Integer> referralCount = new HashMap<>();

        for (int i = 0; i < from.length; i++) {
            referralMap.computeIfAbsent(from[i], t -> new ArrayList<>()).add(to[i]);

            referralCount.put(from[i],0);
            referralCount.put(to[i],0);
        }

        for(String person : referralMap.keySet()){
            if(referralCount.get(person) == 0){
                int count = bfs(person, referralMap, referralCount);
                referralCount.put(person,count);
            }
        }
        PriorityQueue<People> pq = new PriorityQueue<>(Comparator.comparing(a->-a.count));

        for(String person : referralCount.keySet()){
            System.out.println("person : " + person + ", count : "+ referralCount.get(person));
            pq.add(new People(person, referralCount.get(person)));
        }

        while(!pq.isEmpty()){
            People people = pq.poll();
            System.out.println(people.name + "," + people.count);
        }

    }
    
    static int bfs(String person, Map<String, List<String>> referralMap, Map<String, Integer> referralCount){
        Set<String> visited = new HashSet<>();
        int total = 0;
        Queue<String> queue = new LinkedList<>(); //왜 이거
        queue.add(person);
        visited.add(person);

        while (!queue.isEmpty()){
            String curPerson = queue.poll();

            if(referralMap.containsKey(curPerson)){
                for (String candidate : referralMap.get(curPerson)){
                    if(visited.contains(candidate)) continue;

                    queue.add(candidate);
                    visited.add(candidate);
                    total++;
                }
            }
        }
        return total;
    }

    static class People{
        int count;
        String name;

        People(String n, int c){
            this.count = c;
            this.name = n;
        }
    }
}
