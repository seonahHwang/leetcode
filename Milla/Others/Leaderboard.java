package Milla.Others;

import java.util.*;

public class Leaderboard {
    /*
    * 1. **순환 참조**: 사용자가 서로를 추천하는 경우가 있을 수 있습니다. 예를 들어, 사용자 A가 사용자 B를 추천하고, 사용자 B가 사용자 A를 추천하는 경우입니다.
    2. **빈 리스트**: 입력으로 제공된 추천 목록이 빈 경우입니다. 이 경우, 리더보드는 비어 있어야 합니다.
    3. **중복 추천**: 같은 사용자가 여러 번 동일한 사용자에게 추천을 하는 경우, 이러한 중복을 어떻게 처리할 것인지에 대한 규칙이 필요합니다.
    4. **하위 사용자 없음**: 사용자가 추천한 하위 사용자가 없는 경우, 그 사용자의 추천 수는 0이어야 합니다.
    5. **케이스 민감도**: 사용자 이름이 대소문자에 따라 다를 경우, 동일 사용자로 인식할지 여부입니다.
    * */

    /*
    * Users can refer each other to Robinhood. We want keep track of who is responsible for the most referrals and display the top users on a leaderboard.
If user A refers user B, and user B refers user C. Then the leaderboard looks like this:
Explanation: User B has 1 referral for referring user C. User A has 2 referrals because they referred user B,
Given a list of referrals (Example Input: [ ["A","B"] , ["B", "C"] ], write a function that determines the leaderboard order.
    *
    *
    * Brainstorm
    *
    * Edgecase
    * - What happen if there is a cycle A->B, B->A
    * - What if there is no referral at all -> should we return empty array?
    * - Do we care about lowercase in name of people?
    * - What is someone refer same person more than once? we need to count all referal of just once?
    * - What if someone hasn't refer anyone -> should we return 0?
    *
    * Plan
    * - represent relationship referral with graph network.
    * - traversal network using BFS
    * - calulate the size of referral relationship on each people
    * - return the size of each referral
    *
    * TC
    * O(V+E) V : each people, E : each referral. when we use BFS traversal -> O(V+E)
    *
    * SC
    * O(V+E) : store to hashmap to track the size of referral network. // 다시준비
    * // The HashMap for storing referral relationships takes O(N + E) space
    *
    * */
    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D", "F"};
        String[] b = {"H", "D", "E", "G", "H"};
        leaderBoarder(a,b);

    }

    static int[] leaderBoarder(String[] a, String[] b){ //a: {A,B,C} b: {B,C,D}
        // A -> B, B-> C, C -> D
        // A -> B -> C -> D
        // A has 3 referrals
        // B -> C -> D // B has 2 referrals
        // C -> D // C has 1 refererral
        // D -> D has 0 referrals

        Map<String,List<String>> referrals = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            referrals.computeIfAbsent(a[i], t -> new ArrayList<>()).add(b[i]);
        }
        // A -> B
        // B -> C
        // C -> D

        int[] result = new int[referrals.size()]; //3

        int j = 0;
        for (String referPerson : referrals.keySet()){ //3
            result[j] = bfs(referrals, referPerson); // result[0] = 3 / result = {3,2,1}
            j++;
        }
//        Integer[] arrInteger = Arrays.stream(result).boxed().toArray(Integer[]::new);
//        Arrays.sort(arrInteger, Collections.reverseOrder());// 숫자순 정렬
        //문자순 정렬
        return result;
    }

    static int bfs(Map<String,List<String>> referrals, String startPerson){ // A
        int number = 0;

        Queue<String> queue = new LinkedList();
        queue.add(startPerson); // A

        while (!queue.isEmpty()){
            String curPerson = queue.poll(); // A -> B -> C -> D
            number++; //number = 4
            if(referrals.get(curPerson) == null) continue;

            List<String> referraled = new ArrayList<>();
            referraled = referrals.get(curPerson);
            for (int i = 0; i < referraled.size(); i++) {
                queue.add(referraled.get(i)); // Queue : D
            }
        }
        //number 4
        return number - 1; // A -> B -> C -> D // 3
    }
}