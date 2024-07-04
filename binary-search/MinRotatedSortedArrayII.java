Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

Intuition:
  Binary Search, Duplicates(search space trim), min value(unsorted half space)

Solution:
class MinRotatedSortedArrayII {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while(start < end) {
            mid = (end-start)/2 + start;

            if(nums[start] == nums[mid]  && nums[mid] == nums[end]) {
                start += 1;
                end -= 1;
                continue;
            }
            if(nums[start] <= nums[mid]) {
                if(nums[mid] <= nums[end]) {
                    return nums[start];
                } else {
                    start = mid+1;
                }
            } else {
                end = mid;
            }
        }
        return nums[start];
        
    }
}
