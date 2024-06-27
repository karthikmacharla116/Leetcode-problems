Problem Link: https://leetcode.com/problems/search-insert-position/description/

Intution:
  Lower bound
  
class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lowerBound = nums.length;

        int start = 0;
        int end = lowerBound-1;
        int mid;

        while(start <= end) {
            mid = (end-start)/2 + start;
            if(nums[mid] >= target) {
                lowerBound = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return lowerBound;
    }
}
