package Milla.Sort;

import java.util.Arrays;
import java.util.List;

public class Notification {
    static int count[];
    public static void main(String[] args) {
        Integer arr[] = {2, 3, 4, 2, 3, 6, 8, 4, 5};
//        Integer arr[] = {10,20,30,40,50};
//        Integer arr[] = {10,20,30,40,50};
//        Integer arr[] = {1, 2, 3, 4, 4};
        List<Integer> li = Arrays.asList(arr);
        System.out.println(activityNotifications(li,5));
    }

    // 활동 알림을 계산하는 메소드
    public static int activityNotifications(List<Integer> expenditure, int d) {
        int answer = 0;
        count = new int[201];
        double mid;

        for(int i = 0 ; i < d ; i++){
            count[expenditure.get(i)]++;
        }

        for (int i = d ; i < expenditure.size() ; i++){
            mid = getMedian(d);

            if(mid * 2 <= expenditure.get(i)) answer++;

            count[expenditure.get(i)]++;
            count[expenditure.get(i-d)]--;
        }
        return answer;
    }

    public static double getMedian(int d){
        int sum = 0;

        if(d % 2 == 0){
            int first = -1;
            int second = -1;

            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if(first == -1 && sum >= d/2){
                    first = i;
                }
                if(second == -1 && sum >= d/2 + 1){
                    second = i;
                    return (second+first)/2.0;
                }
            }

        }else {
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if(sum > d/2){
                    return i;
                }
            }
        }
        return 0;
    }
}
