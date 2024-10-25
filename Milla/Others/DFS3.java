package Milla.Others;

import java.util.*;


import java.util.*;

public class DFS3 {
    // Entry point of the program
    public static void main(String[] args) {
        // Arrays representing referrers and referees
        String[] array1 = {"A", "A", "C"};  // Referrer list
        String[] array2 = {"B", "C", "D"};  // Referee list
        // Solve the referral counting problem using the provided arrays
        solve(array1, array2);
    }

    // Method to count the number of referrals for each person based on referrer-referee relationships
    static void solve(String[] from, String[] to) {
        // Map to store the referrals: key is the referrer and value is a list of referees
        Map<String, List<String>> referralMap = new HashMap<>();
        // Map to keep track of the referral count for each person
        Map<String, Integer> referralCount = new HashMap<>();

        // Loop to initialize referralMap and referralCount
        for (int i = 0; i < from.length; i++) {
            // If a referrer does not exist in referralMap, create a new list for them
            referralMap.computeIfAbsent(from[i], t -> new ArrayList<>()).add(to[i]);
            // Initialize referral count for both referrer and referee to zero
            referralCount.put(from[i], 0);
            referralCount.put(to[i], 0);
        }

        // Set to track visited individuals during the DFS to prevent counting them multiple times
        Set<String> visited = new HashSet<>();

        // Iterate over each unique person in the referralMap to calculate their referrals
        for (String person : referralMap.keySet()) {
            // Only perform DFS for persons who have not been counted yet
            if (referralCount.get(person) == 0) {
                // Start the DFS to count referrals for this person

                dfs(referralMap, referralCount, visited, person);
            }
        }

        // Output the final referral counts for each person
        for (String person : referralCount.keySet()) {
            System.out.println(person + ": " + referralCount.get(person) + " referrals");
        }
    }

    // Recursive method to perform DFS and calculate the referral counts for a given person
    static int dfs(Map<String, List<String>> referralMap, Map<String, Integer> referralCount, Set<String> visited, String people) {
        // If the person has already been visited, return their existing referral count
        if (visited.contains(people)) return referralCount.get(people);
        // Mark the person as visited
        visited.add(people);
        // Initialize the count of referrals for this person
        int count = 0;

        // Check if this person has any referrals in the referralMap
        if (referralMap.containsKey(people)) {
            // For each referee, recursively count their referrals
            for (String candidate : referralMap.get(people)) {
                if(visited.contains(candidate)) continue;
                // Accumulate the referral count including this direct referral
                count += dfs(referralMap, referralCount, visited, candidate) + 1;
                System.out.println(people + " -> " + candidate + ":" + count);
            }
        }
        // Store the total referral count for this person in the referralCount map
        referralCount.put(people, count);
        // Return the total count of referrals for this person
        return count;  // Returns 0 if there are no referrals
    }
}

