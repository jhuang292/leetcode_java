class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int i;
        for (i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
        }
        
        if (i == 0) {
            return binarySearch(matrix[0], target);
        } else {
            return binarySearch(matrix[i-1], target);
        }
        
        
    }
    
    public boolean binarySearch(int[] A, int t) {
        
        if (A.length == 1) {
            if (A[0] == t) {
                return true;
            }
            return false;   
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            
            if (A[mid] == t) {
                return true;
            } else if (A[mid] < t) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }
        return false;
    }
}
