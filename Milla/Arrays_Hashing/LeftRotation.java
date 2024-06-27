package Milla.Arrays_Hashing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        List<Integer> li = rotLeft(Arrays.asList(1,2,3,4,5),4);
        for(Integer a : li){
            System.out.println(a);
        }
    }
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> li = new LinkedList<>();
        // Write your code here
        for (int i = 0; i < a.size(); i++) {
            if(i+d >= a.size()){
                li.add(i,a.get((i+d)%a.size()));
            }else {
                li.add(i,a.get(i+d));
            }
            System.out.println();
        }
        return li;
    }
}
