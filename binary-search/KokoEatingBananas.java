Problem Link: https://leetcode.com/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75

Intuition: 
  Binary Search O(n*log(maxPileValue))

Solution:
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        //Time complexity: O(Max(piles)*n) BS on answers (result always is "low" - opposite polarity)
        //Binary search: O(n*log(maxpilesValue))

        // int n = piles.length;

        // int max = piles[0];
        // for(int i=1;i<n;i++) {
        //     if(piles[i] > max)
        //         max = piles[i];
        // }

        int ans = 1000000000; //max

        int low = 1;
        int high = 1000000000; //max
        int mid;
        while(low <= high) {
            mid = (high-low)/2 + low;
            if(calculate(piles, mid) <= h) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }

    int calculate(int[] piles, int eatTime) {
        int maxHours = 0;
        for(int p: piles) {
            int div = p/eatTime;
            maxHours += div;
            if(p%eatTime != 0)
                maxHours++;
        }
        return maxHours;
    }
}
