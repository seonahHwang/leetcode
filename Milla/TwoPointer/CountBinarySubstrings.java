package Milla.TwoPointer;

public class CountBinarySubstrings {
    //0과 1의 개수가 동일한 substring 찾기
    /*
    * 처음엔 Left, right를 옮겨가며 슬라이딩 윈도우로 풀어야한다고 생각했는데,
    * 결국에는 substring pair의 개수를 찾으면된다.
    * 중요한건 0과 1이 떨어져있으면 의미를 잃기 때문에, 연속되는지 아닌지를 계속봐야하고
    * 연속되지 않는 시점에, 이전 그룹의 크기와 지금 그룹의 크기를 비교해서 더 작은 값을 결과 값에 더해준다.
    * 결국 더 작은값을 기준으로 그 안에서 pair가 생길 수 있기 때문.
    *
    * 1. 연속되는지 아닌지 확인
    * 2. 연속되는 그룹안의 길이를 카운트
    * 3. 연속이 끊기면 그 때 이전 그룹길이와 현재 그룹길이 비교, 최소값을 선택 후 결과값에 더해주기
    *
    * */
    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }
    public static int countBinarySubstrings(String s) {
        int curr = 1;
        int prev = 0;
        int result = 0;

        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){ //연속되는지 확인
                curr++; //연속되는만큼 현재 그룹의 길이를 늘려준다.
            }else { //연속이 끊김
                result += Math.min(prev,curr);
                prev = curr;
                curr = 1;
            }
        }
        result += Math.min(prev,curr);
        return result;
    }
}
