package Milla.BinarySearch;

public class SearchMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid/n][mid%n];

            if(target == midVal) return true;
            else if(target > midVal){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
