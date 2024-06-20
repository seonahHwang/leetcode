package Milla.Arrays_Hashing;

import java.util.Arrays;
import java.util.Comparator;

public class SortInteger {
    /*
     * for문 돌면서 이진수로 변환하고
     * bit수를 기준으로 정렬한 값을 리턴해야함
     * 정렬을 어떻게 할지? Arrays.sort!
     * */
    public static void main(String[] args) {
//        int a[] = {0,1,2,3,4,5,6,7,8};
        int a[] = {1024,512,256,128,64,32,16,8,4,2,1};

        System.out.println(Arrays.toString(sortByBits(a)));
    }
    public static int[] sortByBits(int[] arr) {
        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new); //Integer 배열로 변환

        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int bitA = Integer.bitCount(o1);
                int bitB = Integer.bitCount(o2);
                if(bitB != bitA) return bitA - bitB;
                else return o1- o2;
            }
        });
        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    }
}
