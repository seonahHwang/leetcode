package Milla.practice;

public class encrypt {
    public static void main(String[] args) {
        System.out.println(decryptPassword("51Pa*0Lp*0e"));
    }

    public static String decryptPassword(String s){
        char a[] = s.toCharArray();
        int num[] = new int[s.length()];
        int l = 0; int r = s.length() - 1;
        while (l<r){
            if(Character.isDigit(a[l])){
                while (l <r && a[r] != '0'){
                    r--;
                }
                char tmp = a[r];
                a[r] = a[l];
                a[l] = tmp;

                l++;
            }else l++;
        }

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i < s.length() - 2 && Character.isUpperCase(a[i]) && Character.isLowerCase(a[i+1]) && a[i+2] == '*'){
                char tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
                a[i+2] = '&';
            }
        }

        String str = new String(a);
        str = str.replace("0","");
        str = str.replace("&","");
        return str;
    }
}
