class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int start = 0;
        int end = matrix.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        int lastRow = (matrix[end][0] > target) ? start : end;
        
        for (int row = 0; row <= lastRow; row++) {
            start = 0;
            end = matrix[row].length -1;
            
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if(matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
        
    }
}
