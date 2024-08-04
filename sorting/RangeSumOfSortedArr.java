Problem Link: https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/?envType=daily-question&envId=2024-08-04

class RangeSumOfSortedArr {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sumArr = new int[n*(n+1)/2];

        int index= 0;

        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i; j<n;j++) {
                sum += nums[j];
                sumArr[index++] = sum; 
            }
        }

        Arrays.sort(sumArr);
        int result = 0;
        int mod = (int)1e9 + 7;
        while(left<=right) {
            result = (result + sumArr[left-1])%mod;
            left++;
        }
        return result;
    }
}
