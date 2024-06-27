package Milla.Arrays_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsOfSongs {
    public static void main(String[] args) {
//        int a[] = {30,20,150,100,40};
        int a[] = {60,60,60};
        System.out.println(numPairsDivisibleBy60(a));
    }
//    public static int numPairsDivisibleBy60(int[] time) {
//        HashMap<Integer,Integer> map = new HashMap<>(); //빈도수도 체크
//        int[] range = new int[(500/30)+1];
//        int answer = 0;
//
//        for (int i = 0; i < time.length; i++) {
//            map.put(time[i],map.getOrDefault(time[i],0)+1);
//        }
//
//        int j = 0;
//        for (int i = 30; i <= 500; i+=30) {
//            range[j] = i;
//            j++;
//        }
//
//        Arrays.sort(time);
//        for (int i = 0; i < time.length; i++) {
//            System.out.println(time[i]);
//            for (int k = 0; k < range.length; k++) {
//                int diff = range[k] - time[i];
//                if(diff < time[i]) continue;
//                if(diff == time[i] && map.containsKey(diff) && map.get(diff) > 1) { //자신과 동일한 값과 pair를 이루지만 나와 같은 인덱스는 아닌 경우
//                    answer++;
//                }
//                if(diff != time[i] && map.containsKey(diff)) { //조건에 해당하는 경우, 그런데 나 자신이 아니고, 또한 이미 포함된 경우가 아니여야함!
//                    System.out.println("diff"+diff);
//                    answer++;
//                }
//            }
//            System.out.println("answer"+answer);
//        }
//
//        return answer;
//    }
    //이미 포함된 경우가 아니어야 한다는 걸 해결하기 위해서 값이 이미 추가되어있는게 아니라, 추가해 나가는 방식으로 풀어아햠 아래처럼

    public static int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int t : time){
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;

            count += map.getOrDefault(complement,0);
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }

        return count;
    }
}
