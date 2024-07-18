Problem Link: https://leetcode.com/problems/find-peak-element/description/

Intuition:
  Identify whether our mid is in increasing /decreasing curve

class PeakElementI {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return 0;
        
        if(nums[0] > nums[1])
            return 0;
        
        if(nums[n-1] > nums[n-2])
            return n-1;
        
        int start = 1;
        int end = n-2;
        int mid;

        while(start <= end) {
            mid = (end-start)/2 + start;

            if(nums[mid]>nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            
            if(nums[start] <= nums[mid]) {
                if(nums[mid-1] <= nums[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if(nums[mid] >= nums[mid+1]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return start;
    }
}
