package Milla.Others;
import java.util.*;
import java.util.*;


public class GPTDFS {
    private Map<String, List<String>> referralMap = new HashMap<>();
    private Map<String, Integer> referralCount = new HashMap<>();

    // 추천 관계를 추가하는 메소드
    public void addReferral(String referrer, String referee) {
        referralMap.computeIfAbsent(referrer, k -> new ArrayList<>()).add(referee);
        referralCount.putIfAbsent(referrer, 0);
        referralCount.putIfAbsent(referee, 0);
    }

    // DFS를 이용하여 추천 수를 계산하는 메소드
    private int dfs(String person, Set<String> visited) {
        // 이미 방문한 경우, 저장된 추천 수를 반환
        if (visited.contains(person)) {
            return referralCount.get(person);
        }

        // 현재 인물 방문 처리
        visited.add(person);
        int totalCount = 0;

        // 현재 인물이 추천한 모든 사람을 탐색
        if (referralMap.containsKey(person)) {
            for (String referred : referralMap.get(person)) {
                totalCount += 1 + dfs(referred, visited);
            }
        }

        // 추천 수를 저장
        referralCount.put(person, totalCount);
        return totalCount;
    }

    // 모든 사람에 대한 추천 수를 계산하는 메소드
    public void calculateReferralCounts() {
        for (String person : referralMap.keySet()) {
            if (!referralCount.containsKey(person)) {
                dfs(person, new HashSet<>());
            }
        }
    }

    // 결과를 출력하는 메소드
    public void printReferralCounts() {
        for (String person : referralCount.keySet()) {
            System.out.println(person + ": " + referralCount.get(person) + " referrals");
        }
    }

    public static void main(String[] args) {
        GPTDFS tracker = new GPTDFS();

        // 예제 입력
        tracker.addReferral("A", "B");
        tracker.addReferral("B", "C");
        tracker.addReferral("C", "D");
        tracker.addReferral("D", "E");
        tracker.addReferral("B", "E");

        // 추천 수 계산
        tracker.calculateReferralCounts();
        // 결과 출력
        tracker.printReferralCounts();
    }
}