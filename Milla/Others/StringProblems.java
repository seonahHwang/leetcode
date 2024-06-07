package Milla.Others;

public class StringProblems {
    public static void main(String[] args) {
        String s = "123";
        reverse(s);
    }

    public static String reverse(String s){
        char arr[] = s.toCharArray();
        char reverse[] = new char[s.length()];

        for(int i=0;i<s.length();i++){ //I start a loop to go through each character in the original string 's'
            reverse[s.length()-1-i] = arr[i];
        }
        String result = new String(reverse);
        //After the loop, I'm gonna convert character array back into a new String.

        System.out.println(result);
        return result;
    }
}
