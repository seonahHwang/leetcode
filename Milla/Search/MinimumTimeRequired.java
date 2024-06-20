package Milla.Search;

import java.util.Arrays;

public class MinimumTimeRequired {
    public static void main(String[] args) {
//        3 10
//        1 3 4
//        long[] machine = {1L, 3L, 4L};
//        long goal = 10;
        long[] machine = {2L, 3L}; //값 6
        long goal = 5;
        System.out.println(minTime(machine,goal));
    }
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);

        long l = 1;
        long r = goal*machines[machines.length-1];

        while (l<r){
            long mid = (l+r)/2;
            long total = 0;
            for (int i = 0; i < machines.length; i++) {
                total += mid/machines[i];
            }

            if(total < goal){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l; //왜 l인 걸까!!! 그리고 와일문 종료로 그만두는거랑 타겟이 일치해서 리턴하는거랑 어떤 차이가 있는지 확인하기
    }
}
