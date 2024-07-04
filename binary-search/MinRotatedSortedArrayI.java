Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

Intuition:
  Binary Search, Rotated sorted array, Minimum value(try to find the unsorted half of array)

Solution:

class MinRotatedSortedArrayI {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low < high) {
            mid = (high - low)/2 + low;

            //check the left- half sorted or not
            if(nums[low] <= nums[mid]) {
                if(nums[mid] <= nums[high]) {
                    return nums[low];
                } else {
                    //right unsorted
                    low = mid+1;
                }
            } else {
                high = mid;
            }

        }
        return nums[low];
    }
}
