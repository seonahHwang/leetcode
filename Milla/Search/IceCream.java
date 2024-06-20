package Milla.Search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IceCream {
    public static void main(String[] args) {
        Integer[] a = {1,4,5,3,2};
        int m = 4;
        List<Integer> li = Arrays.asList(a);
        whatFlavors(li,m);
    }
    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < cost.size(); i++) {
            int diff = money - cost.get(i);
            if(map.containsKey(diff)){
                int a = map.get(diff) + 1;
                int b = i + 1;
                if(a > b) {
                    System.out.println(b + " " + a);
                }else {
                    System.out.println(a + " " + b);
                }
            }
            map.put(cost.get(i),i); // 미리 map에 다 저장해두는게 아니면 i가 겹칠일이 없음! list를 한 번만 순회하고도 답 찾기 가능 !
        }
    }
}
