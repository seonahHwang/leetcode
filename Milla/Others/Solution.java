package Milla.Others;

import java.util.*;

public class Solution {
    // Method to get the leaderboard
    public Map<String, Integer> getLeaderboard(List<List<String>> edges) {
        // Set to keep track of unique nodes (users)
        Set<String> nodes = new HashSet<>();

        // Adjacency list for the referral graph
        Map<String, List<String>> adj = new HashMap<>();

        // Populate nodes and adjacency list
        for (List<String> edge : edges) {
            String n1 = edge.get(0);
            String n2 = edge.get(1);
            nodes.add(n1);
            nodes.add(n2);
            adj.putIfAbsent(n1, new ArrayList<>());
            adj.get(n1).add(n2);
        }

        // Map to store the referral count for each user
        Map<String, Integer> leaderboard = new HashMap<>();
        // Set to track visited nodes during DFS
        Set<String> visit = new HashSet<>();
        // Map to memoize the referral counts
        Map<String, Integer> memo = new HashMap<>();

        // Depth-First Search (DFS) function to calculate referrals
        for (String n : nodes) {
            leaderboard.put(n, dfs(n, adj, visit, memo));
        }

        return leaderboard;
    }

    // Recursive DFS method to count referrals
    private int dfs(String person, Map<String, List<String>> adj, Set<String> visit, Map<String, Integer> memo) {
        // If already visited, return 0 to avoid counting again
        if (visit.contains(person)) {
            return 0;
        }

        // If this person's referral count is already computed, return it
        if (memo.containsKey(person)) {
            return memo.get(person);
        }

        // Mark the person as visited
        visit.add(person);
        int totalReferrals = 0;

        // Visit all referred users
        for (String referredUser : adj.getOrDefault(person, new ArrayList<>())) {
            totalReferrals += 1 + dfs(referredUser, adj, visit, memo);
        }

        // Unmark the person as visited
        visit.remove(person);
        // Memoize the total referrals for this person
        memo.put(person, totalReferrals);

        return totalReferrals;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        // Sample input
        List<List<String>> edges = new ArrayList<>();
        edges.add(Arrays.asList("A", "B"));
        edges.add(Arrays.asList("B", "A"));
//        edges.add(Arrays.asList("C", "D"));

        // Get the leaderboard
        Map<String, Integer> leaderboard = solution.getLeaderboard(edges);

        // Output the leaderboard
        for (Map.Entry<String, Integer> entry : leaderboard.entrySet()) {
            System.out.println("User " + entry.getKey() + ": " + entry.getValue() + " Referrals");
        }
    }
}
