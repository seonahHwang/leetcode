package Milla.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FrequencyQueries {
    public static void main(String[] args) {
//        HashMap<Integer,Integer> valueToFreq = new HashMap<>(); //숫자 -> 빈도
//        HashMap<Integer,Integer> freqToCount = new HashMap<>(); //빈도 -> 그 빈도를 가지는 숫자의 개수
        List<List<Integer>> queries = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(2, 2),
                Arrays.asList(3, 2),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 2)
        );
        List<Integer> result = freqQuery(queries);
        System.out.println(result); // 출력: [0, 1]
        /*
        * 1 3
            2 3
            3 2
            1 4
            1 5
            1 5
            1 4
            3 2
            2 4
            3 2
        * */
    }
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> subList = null;
        int command = 0;
        int num = 0;

        HashMap<Integer,Integer> valueToFreq = new HashMap<>();
        HashMap<Integer,Integer> freqToCount = new HashMap<>();
        List<Integer> answer = new LinkedList<>();
        int freq = 0;
        int oldFreq = 0;
        int newFreq = 0;

        for (int i = 0 ; i < queries.size() ; i++){
            subList = queries.get(i);
            command = subList.get(0);
            num = subList.get(1);

            switch (command){
                case 1:
                    oldFreq = valueToFreq.getOrDefault(num,0);
                    newFreq = oldFreq + 1;
                    valueToFreq.put(num,newFreq);

                    if(oldFreq > 0){
                        freqToCount.put(oldFreq,freqToCount.get(oldFreq)-1);
                    }
                    freqToCount.put(newFreq,freqToCount.getOrDefault(newFreq,0)+1);
                    break;

                case 2:
                    oldFreq = valueToFreq.getOrDefault(num,0);

                    if(oldFreq > 0){
                        newFreq = oldFreq - 1;
                        valueToFreq.put(num,newFreq);
                        freqToCount.put(oldFreq,freqToCount.get(oldFreq)-1);

                        if(newFreq > 0){
                            freqToCount.put(newFreq,freqToCount.getOrDefault(newFreq,0)+1);
                        }
                    }
                    break;

                case 3:
                    if(freqToCount.getOrDefault(num,0) > 0 ) answer.add(1);
                    else answer.add(0);
                    break;
            }

        }
        return answer;
    }
}
