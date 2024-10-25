package Milla.Others;
import java.util.*;

public class DFS2 {

    // HashMap to store each person's direct referrals
    private Map<String, List<String>> referralsMap = new HashMap<>();
    // HashMap to store the final referral count for each person
    private Map<String, Integer> referralCount = new HashMap<>();
    // Set to keep track of visited nodes to detect cycles
    private Set<String> visited = new HashSet<>();
    // Set to track nodes currently in the DFS call stack to detect cycles
    private Set<String> currentStack = new HashSet<>();

    // Function to add referrals (A -> B means A refers B)
    public void addReferral(String referrer, String referee) {
        referralsMap.putIfAbsent(referrer, new ArrayList<>());
        referralsMap.get(referrer).add(referee);

        // Initialize referral counts for each person if not already set
        referralCount.putIfAbsent(referrer, 0);
        referralCount.putIfAbsent(referee, 0);
    }

    // DFS function to calculate the number of referrals for each user
    public int dfs(String person) {
        // If we already calculated the referral count for this person, return it (Memoization)
        if (referralCount.get(person) > 0) {
            return referralCount.get(person);
        }

        // Mark the person as visited and currently being processed
        visited.add(person);
        currentStack.add(person);

        // Explore the referrals for the current person
        if (referralsMap.containsKey(person)) {
            for (String referred : referralsMap.get(person)) {
                // If there's a cycle, we stop further exploration
                if (currentStack.contains(referred) ) {
                    continue;  // Detected a cycle, skip this node
                }

                // If the referred person hasn't been visited, perform DFS on them
                if (!visited.contains(referred)) {
                    referralCount.put(person, referralCount.get(person) + 1 + dfs(referred));
                } else {
                    // If already visited, just count their referrals
                    referralCount.put(person, referralCount.get(person) + 1 + referralCount.get(referred));
                }
            }
        }

        // Remove the person from the current DFS call stack
        currentStack.remove(person);
        return referralCount.get(person);
    }

    // Function to calculate referrals for all users
    public void calculateReferralCounts() {
        for (String person : referralsMap.keySet()) {
            if (referralCount.get(person) == 0) {
                dfs(person);  // Run DFS for unprocessed people
                System.out.println("-----------------");
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
        DFS2 tracker = new DFS2();

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
