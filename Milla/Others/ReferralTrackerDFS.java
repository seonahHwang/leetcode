package Milla.Others;

import java.util.*;

public class ReferralTrackerDFS {
    private Map<String, List<String>> referralsMap;
    private Map<String, Integer> referralCount;
    private Set<String> visited;

    public ReferralTrackerDFS() {
        referralsMap = new HashMap<>();
        referralCount = new HashMap<>();
        visited = new HashSet<>();
    }

    // 추천인과 추천받는 사람을 추가하는 메서드
    public void addReferral(String referrer, String referee) {
        referralsMap.putIfAbsent(referrer, new ArrayList<>());
        referralsMap.get(referrer).add(referee);
        referralCount.putIfAbsent(referrer, 0);
        referralCount.putIfAbsent(referee, 0);
    }

    // DFS를 이용해 추천 수를 계산하는 메서드
    public int dfs(String person) {
        if (visited.contains(person)) {
            System.out.println("이미방문 "+ person);
            return referralCount.get(person); // 이미 처리한 경우, 결과 반환
        }

        visited.add(person);
        int count = 0; // 현재 사람의 추천 수

        // 해당 사람의 모든 추천인에게 DFS 수행
        if (referralsMap.containsKey(person)) {
            for (String referral : referralsMap.get(person)) {
//                if(visited.contains(referral)) continue;
                System.out.println("전 // referral : "+referral + ", count : "+count);
                count += dfs(referral); // 직접 추천 포함
                System.out.println("후 referral : "+referral + ", count : "+count);
            }
        }

        referralCount.put(person, count); // 최종 추천 수 저장
        return count;
    }

    // 추천 수를 계산하는 메서드
    public void calculateReferralCounts() {
        for (String person : referralsMap.keySet()) {
            if (!visited.contains(person)) {
                dfs(person);
                System.out.println("-------");
            }
        }
    }

    // 결과를 출력하는 메서드
    public Map<String, Integer> getReferralCounts() {
        return referralCount;
    }

    public static void main(String[] args) {
        ReferralTrackerDFS counter = new ReferralTrackerDFS();

        // 테스트 케이스 추가
        counter.addReferral("A", "B");
        counter.addReferral("B", "A");
//        counter.addReferral("C", "D");

        counter.calculateReferralCounts();

        // 결과 출력
        Map<String, Integer> result = counter.getReferralCounts();
        for (String person : result.keySet()) {
            System.out.println(person + ": " + result.get(person) + " referrals");
        }
    }
}