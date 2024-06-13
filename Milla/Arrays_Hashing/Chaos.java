package Milla.Arrays_Hashing;

import java.util.LinkedList;
import java.util.List;

public class Chaos {
    public static void main(String[] args) {
        List<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(1);
        q.add(5);
        q.add(3);
        q.add(4);
        minimumBribes(q);
    }
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {

            if (q.get(i) - (i + 1) > 2) { //현재 시점의 사람이 뇌물을 2개 넘게 썼는지를 확인. 2이상 차이나면 더 많이 이동했다는 의미!
                System.out.println("Too chaotic");
                return; //return 필수!!
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) { //내 앞에 뇌물을 쓴 케이스가 있는지 확인 
                if (q.get(j) > q.get(i)) { //위치가 앞인데, 나보다 크면 뇌물쓴거임
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }
}
