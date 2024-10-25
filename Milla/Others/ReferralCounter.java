package Milla.Others;

import java.util.*;

public class ReferralCounter {
    private Map<String, List<String>> referralsMap;
    private Map<String, Integer> referralCount;
    private Set<String> visited;
    private Set<String> currentStack; // 현재 탐색 중인 노드 집합

    public ReferralCounter() {
        referralsMap = new HashMap<>();
        referralCount = new HashMap<>();
        visited = new HashSet<>();
        currentStack = new HashSet<>();
    }

    public void addReferral(String referrer, String referee) {
        referralsMap.putIfAbsent(referrer, new ArrayList<>());
        referralsMap.get(referrer).add(referee);
        referralCount.putIfAbsent(referrer, 0);
        referralCount.putIfAbsent(referee, 0);
    }

    // DFS를 이용해 추천 수를 계산하는 메서드
    public void dfs(String person) {
        if (visited.contains(person)) {
            return; // 이미 처리한 경우, 종료
        }

        // 사이클 감지
        if (currentStack.contains(person)) {
            System.out.println("Cycle detected at: " + person);
            return; // 사이클이 발견되면 종료
        }

        // 현재 탐색 중인 노드 추가
        currentStack.add(person);
        visited.add(person);

        int count = 0; // 현재 사람의 추천 수

        // 해당 사람의 모든 추천인에게 DFS 수행
        if (referralsMap.containsKey(person)) {
            for (String referral : referralsMap.get(person)) {
                count += 1; // 직접 추천 포함
                dfs(referral); // 재귀 호출
                count += referralCount.get(referral); // 간접 추천 수 추가
            }
        }

        referralCount.put(person, count); // 최종 추천 수 저장

        // 현재 탐색 중인 노드 제거
        currentStack.remove(person);
    }

    public void calculateReferralCounts() {
        for (String person : referralsMap.keySet()) {
            if (!visited.contains(person)) { // 방문하지 않은 경우만 DFS 수행
                dfs(person);
            }
        }
    }

    public Map<String, Integer> getReferralCounts() {
        return referralCount;
    }

    public static void main(String[] args) {
        ReferralCounter tracker = new ReferralCounter();

        // Example input
        tracker.addReferral("A", "B");
        tracker.addReferral("B", "A");  // Cycle A <-> B
        tracker.addReferral("C", "D");

        // Calculate referral counts
        tracker.calculateReferralCounts();
        Map<String, Integer> map = tracker.getReferralCounts();
        // Print the leaderboard
        System.out.println();
    }
}
