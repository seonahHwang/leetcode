package Milla.Others;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int f[] = {1,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(f,n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1){
            if(n > 1) return false;
            if(n == 0) return true;
            if(n == 1 && flowerbed[0] == 0) return true;
        }
        int cnt = n;
        for (int i = 0; cnt > 0 && i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                if(i == 0){
                    if(flowerbed[i+1] == 0) {
                        cnt--;
                        flowerbed[i] = 1;
                    }
                }else if(i == flowerbed.length - 1){
                    if(flowerbed[i-1] == 0) {
                        cnt--;
                        flowerbed[i] = 1;
                    }
                }else {
                    if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                        cnt--;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        if(cnt == 0) return true;
        else return false;
    }
}
