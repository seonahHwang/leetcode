package Milla.Others;

import java.util.*;

public class MyDFS {

    static Set<String> currentStack = new HashSet<>();
    public static void main(String[] args) {
        String a[] = {"A","B","C"};
        String b[] = {"B","A","D"};
        solution(a,b);
    }

    static void solution(String[] from, String to[]){
        Map<String, List<String>> referralMap = new HashMap<>();
        Map<String, Integer> referralCountMap = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < from.length; i++) {
            referralMap.computeIfAbsent(from[i], t -> new ArrayList<>()).add(to[i]);
            referralCountMap.put(from[i],0); //count는 dfs에서 할거니까?
            referralCountMap.put(to[i],0);
        }

        for(String fromPerson : referralMap.keySet()){
            if(referralCountMap.get(fromPerson) == 0){
                dfs(referralMap, referralCountMap, visited, fromPerson);
                System.out.println("--------------------------");
            }
        }
        //결과출력
        for(String fromPerson : referralMap.keySet()){
            System.out.println(fromPerson + "refer count : " + referralCountMap.get(fromPerson));
        }
    }

    static int dfs(Map<String, List<String>> referralMap, Map<String, Integer> referralCountMap, HashSet<String> visited, String person){
        if(visited.contains(person)) {
            System.out.println("person : "+ person + " ,"+referralCountMap.get(person));
//            return referralCountMap.get(person);
            return referralCountMap.get(person);
        }

        visited.add(person);
        currentStack.add(person);
        System.out.println("visited.add : "+person);
        int count = 0;

        if(referralMap.containsKey(person)){
            for (String candidate : referralMap.get(person)){
                if(currentStack.contains(candidate)) continue;
                System.out.println("candi : "+candidate);
                count += dfs(referralMap, referralCountMap, visited, candidate) + 1;
            }
        }

        currentStack.remove(person);
        referralCountMap.put(person, count);
        return count; //referralCountMap을 사용하면 다른 경로에서 온 결과 일수도있어서..
    }
}
