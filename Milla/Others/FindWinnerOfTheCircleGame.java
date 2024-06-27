package Milla.Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWinnerOfTheCircleGame {
    public static void main(String[] args) {
        //n = 5, k = 2
        System.out.println(findTheWinner(6,5));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            li.add(i);
        }

        int removeIdx = k - 1;

        while (li.size() > 1){
            li.remove(removeIdx);
            removeIdx = (removeIdx + (k - 1)) % li.size();
        }

        return li.get(0);
    }
}
