class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start, mid, end;
        int[] bound = new int[2];
        
        if (nums.length == 0) {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // Left bound
        start = 0;
        end = nums.length - 1;
        
        while (start + 1 < end) {
            
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            bound[0] = start;
        } else if (nums[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // Right bound
        start = 0;
        end = nums.length - 1;
        
        while (start + 1 < end) {
            
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
    }
}
