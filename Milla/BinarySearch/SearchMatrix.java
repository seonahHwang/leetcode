package Milla.BinarySearch;

public class SearchMatrix {
    /* 4시까지 설명 완성
    * Brute Force way
    * If I approach in brute force way,
    * I need to check every element in matrix which means it takes O(n*m) time complexity.
    *
    * Edge cases
    * if matrix is empty or count of elements in one row is 0, Should I return false?
    *
    * Plan
    * I can think of the entire matrix as a single sorted array.
    * So I can use binary search.
    * First, treat the matrix as a single array.
    * Second, I'll loop in binary search way. and I'm going to divide middle value by n for row index,
    * and do modular middle value by n for column index.
    *
    *
    * TC : O(log(m * n)) This is because time complexity of original binary search is O(logn) but we're performing binary search over 'm*n' elements.
    * SC : O(1) there will not be extra data structure, I will just use extra variable.
    * */
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        /* It verifies if the matrix is null, if it has no rows, or if the first row has no columns.
           If any of these conditions are true, I will return 'false'
         */

        int m = matrix.length; // m means number of rows in the matrix.
        int n = matrix[0].length; //n means number of columns in the matrix.
        int left = 0;
        int right = m * n - 1; // right is the last index of a single array.

        while (left <= right){ //I'll start a while loop that continues as long as left is less than or equal to right.
            int mid = left + (right - left) / 2; // get middle index here.
            int midVal = matrix[mid/n][mid%n]; // middle value is divided by n gives the row index and mid modular by n gives the column index.

            if(target == midVal) return true; //if we find target, return true
            else if(target > midVal){ //if target is greater than middle value, we should find target in right side. so I'll move left pointer to middle + 1.
                left = mid + 1;
            }else { //otherwise, I need to move right pointer to left side.
                right = mid - 1;
            }
        }
        return false;
    }
}
