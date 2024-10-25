package Milla.Others;

import java.util.*;

public class DFS4 {

    static Map<String, List<String>> referralMap;
    static Map<String, Integer> referCount;
    static Set<String> visited;
    public static void main(String[] args) {
        String[] array1 = {"A", "B", "C", "F"};  // Referrer list
        String[] array2 = {"B", "C", "D", "B"};  // Referee list
        // Solve the referral counting problem using the provided arrays
        solve(array1, array2);
    }

    static void solve(String[] from, String[] to){
        referralMap = new HashMap<>();
        referCount = new HashMap<>();
        visited = new HashSet<>();

        for (int i = 0; i < from.length; i++) {
            referralMap.computeIfAbsent(from[i], t -> new ArrayList<>()).add(to[i]);

            referCount.put(from[i],0);
            referCount.put(to[i],0);
        }

        for(String person : referralMap.keySet()){
            if(referCount.get(person) == 0) {
                dfs(person);
            }
        }

        for (String person : referCount.keySet()){
            System.out.println(person + " : " + referCount.get(person));
        }

    }

    static int dfs(String person){
        if(visited.contains(person)){
//            return referCount.get(person);
            return 0;
        }
        visited.add(person);
        int total = 0;
        if(referralMap.containsKey(person)){
            for (String candidate : referralMap.get(person)){
                total += dfs(candidate) + 1;
            }
        }

        referCount.put(person,total);
        return total;
    }
}
