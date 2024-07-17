Problem Link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/

Intuition:
  (even, odd) - element is on right half
  (odd, even) - element id on left half
  to avoid complexity handle the edge cases seperately

Solution:
class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        //eliminate the conditional checks by edge cases
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[n-2] != nums[n-1])
            return nums[n-1];

        //Binary search for 1 to n-2
        int start = 1;
        int end = n-2;
        int mid;

        while(start <= end) {
            mid = (end-start)/2 + start;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            
            //index check : even /odd
            if(mid%2 == 0) {
                //we're standing at an even index
                if(nums[mid] == nums[mid+1]) {
                    //means our single element is on right side
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if(nums[mid] == nums[mid+1]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }

            }
        }
        return nums[start];
    }
}
