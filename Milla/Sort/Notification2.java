package Milla.Sort;

import java.util.Arrays;
import java.util.List;

public class Notification2 {
    public static void main(String[] args) {
//        Integer arr[] = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        Integer arr[] = {1,2,3,4,4};
//        Integer arr[] = {10, 20, 30, 40, 50};

        System.out.println(activityNotifications(Arrays.asList(arr),4));
    }
    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int count[] = new int[201];
        int result = 0;

        for (int i = 0; i < d; i++) {
            count[expenditure.get(i)]++;
        }

        for (int i = d ; i < expenditure.size() ; i++){
            double mid = getMedian(d,count);
            if(mid*2 <= expenditure.get(i)) result++;

            count[expenditure.get(i)]++;
            count[expenditure.get(i-d)]--;
        }
        return result;
    }

    public static double getMedian(int d, int count[]){
        int sum = 0;

        if(d % 2 == 0){
            int first = -1;
            int snd = -1;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if(first == -1 && sum >= d/2){
                    first = i;
                }
                if(snd == -1 && sum >= d/2 + 1){
                    snd = i;
                    return (snd+first)/2.0;
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
