package Milla.Others;

import java.util.*;

//public class Refer {
//    // Method to calculate referrals using BFS
//    public static int bfs(String s, Map<String, List<String>> referrals) {
//        int len = 0;
//        Queue<String> queue = new LinkedList<>();
//        queue.add(s);
//
//        while (!queue.isEmpty()){
//            String cur = queue.poll();
//            len++;
//            List<String> list = referrals.getOrDefault(cur,new ArrayList<>());
//            for (String referred : list){
//                queue.add(referred);
//            }
//        }
//        return len;
//    }
//
//    public static void main(String[] args) {
//        // Input arrays representing referral relationships
//        String[] referrers = {"A", "B", "C", "D", "F"};
//        String[] referred = {"B", "D", "E", "G", "H"};
//        int ans = Integer.MIN_VALUE;
//        Map<String, List<String>> referrals = new HashMap<>();
//
//        for (int i = 0; i < referrers.length; i++) {
//            referrals.computeIfAbsent(referrers[i], k -> new ArrayList<>()).add(referred[i]);
//        }
//        for(String refer : referrals.keySet()){
//            ans = Math.max(ans,bfs(refer,referrals));
//        }
//    }
//
//}

public class Refer {
    /*
    * Brain
    *
    *
    *
    * */
    // I'll define BFS method to calculate the size of the referral network using BFS
    public static int bfs(String s, Map<String, List<String>> referrals) {
        int len = 0;  // I'll initialize len to track the size of the referral network
        Queue<String> queue = new LinkedList<>();  // I'll initialize Queue to facilitate BFS traversal
        queue.add(s);  // I'll Add the starting referrer to the queue

        while (!queue.isEmpty()) {  // I'll Continue the loop until the queue is empty which means that
            // there are still people in the network that we haven't visited.
            // The loop continues until every referrer and their respective referrals have been processed.

            String cur = queue.poll();  // Dequeue the next referrer
            len++;  // Increase the count to track the total number of people in the referral network.

            // Retrieve the list of people referred by the current referrer
            List<String> list = referrals.getOrDefault(cur, new ArrayList<>());

//            Add them to the queue for future processing. This means we will later
//            // visit each of these people and process their own referrals (if any).
            for (String referred : list) {
                queue.add(referred);
            }
        }
        // After the loop finishes, it means we have visited all reachable people in the referral network.
        // I'll Return the total number of people (network size) we processed, which is stored in 'len'.
        return len;
    }


    public static void main(String[] args) {
        // Input arrays representing the referral relationships
        String[] referrers = {"A", "B", "C", "D", "F"};
        String[] referred = {"B", "D", "E", "G", "H"};

        int answer = Integer.MIN_VALUE;  // Initialize the answer with a minimum value,
        // I'll update the answer whenever I find a node with a longer referral chain.

        // A map is for storing each referrer and the list of people they referred
        Map<String, List<String>> referrals = new HashMap<>();

        // I'll go through referrers array to store each referrer and the list of people they referred
        for (int i = 0; i < referrers.length; i++) {
            // For each referrer, I'll add the referred person to their list to traversal a graph using directed person
            referrals.computeIfAbsent(referrers[i], k -> new ArrayList<>()).add(referred[i]);
        }

        // For each referrer, I'll calculate the size of their referral network using BFS
        for (String refer : referrals.keySet()) {
            answer = Math.max(answer, bfs(refer, referrals));  // Update the answer with the maximum network size
        }

        // (You can print the final result or use it as needed)
        // System.out.println("Maximum referral network size: " + ans);
    }
}


