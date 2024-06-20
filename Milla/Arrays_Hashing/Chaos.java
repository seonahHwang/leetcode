package Milla.Arrays_Hashing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Chaos {
    public static void main(String[] args) {
        Integer arr[] = {1,2,5,3,7,8,6,4};
        List<Integer> q = Arrays.asList(arr);
        minimumBribes(q);
    }
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for (int i = 0; i < q.size(); i++) {

            if (q.get(i) - (i + 1) > 2) { //현재 시점의 사람이 뇌물을 2개 넘게 썼는지를 확인. 2이상 차이나면 더 많이 이동했다는 의미!
                System.out.println("Too chaotic");
                return; //return 필수!!
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) { //내 앞에 뇌물을 쓴 케이스가 있는지 확인
                System.out.println("q.get("+j+") > q.get("+i+")" + q.get(j) + " > " + q.get(i));
                if (q.get(j) > q.get(i)) { //위치가 앞인데, 나보다 크면 뇌물쓴거임
                    bribes++;
                }
            }
            System.out.println("=====================");
        }

        System.out.println(bribes);
    }
}
