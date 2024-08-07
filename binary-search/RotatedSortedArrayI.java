Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/

Intuition:
  Binary Search

class RotatedSortedArrayI {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        int mid;
        while(start <= end) {
            mid = (end - start)/2 + start;

            if(nums[mid] == target)
                return mid;
            else if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid])
                    end = mid-1;
                else 
                    start = mid+1;
            } else {
                if(target > nums[mid] && target <= nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }

        return -1;
    }
}
