package Milla.Others;

import java.util.*;

public class Refer {
    // Method to calculate referrals using BFS
    public static int bfs(String s, Map<String, List<String>> referrals) {
        int len = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()){
            String cur = queue.poll();
            len++;
            List<String> list = referrals.getOrDefault(cur,new ArrayList<>());
            for (String referred : list){
                queue.add(referred);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        // Input arrays representing referral relationships
        String[] referrers = {"A", "B", "C", "D", "F"};
        String[] referred = {"B", "D", "E", "G", "H"};
        int ans = Integer.MIN_VALUE;
        Map<String, List<String>> referrals = new HashMap<>();

        for (int i = 0; i < referrers.length; i++) {
            referrals.computeIfAbsent(referrers[i], k -> new ArrayList<>()).add(referred[i]);
        }
        for(String refer : referrals.keySet()){
            ans = Math.max(ans,bfs(refer,referrals));
        }
        System.out.println("ans:"+ans);
    }

}
