Problem Link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14

Intuition:
  Count sort, size of freq array is tricky*

Solution:
class MinIncrementForUnique {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;

        int minIncrement = 0;

        //count sort
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > max)
                max = nums[i];
        }

        //create the freq array of size: max_value+1+(size of input_array)
        int[] freq = new int[max+1+n];

        for(int num: nums)
            freq[num]++;
        
        //iterate
        for(int i=0;i<(max+1+n);i++) {
            if(freq[i] <= 1)
                continue;
            
            int extra = freq[i] - 1;
            freq[i+1] += extra;
            minIncrement += extra;
        }

        return minIncrement;
    }
}
