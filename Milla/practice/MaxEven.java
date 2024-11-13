package Milla.practice;

public class MaxEven {
    static int maxEvenSum(int arr[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > 0) sum += arr[i];
        }

        if(sum %2 == 0) return sum;

        int ans = Integer.MIN_VALUE; //정답변수 따로 선언
        for (int i = 0; i < n; i++) {
            if(arr[i] %2 != 0){
                if(arr[i] > 0){
                    int a = sum - arr[i];
                    ans = Math.max(ans,a);
                }else {
                    int a = sum + arr[i];
                    ans = Math.max(ans,a);
                }
            }
        }
        return ans;
    }

    // driver program
    public static void main(String s[])
    {
//        테스트케이스 1 : val{6,3,4,-1,9,17} 이면 output 38
//        케이스 2 : {-1,-2,-3,8,7} 이면 output 14
//        케이스 3: {2,3,6,-5,10,1,1} 이면 output22

        System.out.println(maxEvenSum(new int[]{6,3,4,-1,9,17}, 6));
        System.out.println(maxEvenSum(new int[]{-1,-2,-3,8,7}, 5));
        System.out.println(maxEvenSum(new int[]{2,3,6,-5,10,1,1}, 7));

    }
}
