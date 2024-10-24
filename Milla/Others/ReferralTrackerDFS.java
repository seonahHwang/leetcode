package Milla.Others;

import java.util.*;

public class ReferralTrackerBFS {

    // HashMap to store each person's direct referrals
    private Map<String, List<String>> referralsMap = new HashMap<>();
    // HashMap to store the final referral count for each person
    private Map<String, Integer> referralCount = new HashMap<>();

    // Function to add referrals (A -> B means A refers B)
    public void addReferral(String referrer, String referee) {
        referralsMap.putIfAbsent(referrer, new ArrayList<>());
        referralsMap.get(referrer).add(referee);

        // Initialize referral counts for each person if not already set
        referralCount.putIfAbsent(referrer, 0);
        referralCount.putIfAbsent(referee, 0);
    }

    // BFS function to calculate the number of referrals for each user
    public void calculateReferralCounts() {
        for (String person : referralsMap.keySet()) {
            if (referralCount.get(person) == 0) {
                bfs(person);
            }
        }
    }

    // BFS to traverse referrals and calculate counts
    private void bfs(String person) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(person);
        visited.add(person);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            // Get the people referred by the current person
            if (referralsMap.containsKey(current)) {
                for (String referred : referralsMap.get(current)) {
                    if (!visited.contains(referred)) {
                        // Increase the referral count for the person who started the referral chain
                        referralCount.put(person, referralCount.get(person) + 1);
                        queue.offer(referred);
                        visited.add(referred);
                    }
                }
            }
        }
    }

    // Function to print the leaderboard (user -> referral count)
    public void printLeaderboard() {
        for (String person : referralCount.keySet()) {
            System.out.println(person + ": " + referralCount.get(person) + " referrals");
        }
    }

    public static void main(String[] args) {
        ReferralTrackerBFS tracker = new ReferralTrackerBFS();

        // Example input
        tracker.addReferral("A", "B");
        tracker.addReferral("B", "A");  // Cycle A <-> B
        tracker.addReferral("C", "D");

        // Calculate referral counts
        tracker.calculateReferralCounts();

        // Print the leaderboard
        tracker.printLeaderboard();
    }
}
