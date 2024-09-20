package Milla.Others;

import java.util.ArrayList;
import java.util.List;

public class Kids {
    public static void main(String[] args) {

    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max,candies[i]);
        }

        for (int i = 0; i < candies.length; i++) {
            if(max <= candies[i] + extraCandies) list.add(true);
            else list.add(false);
        }
        return list;
    }
}
