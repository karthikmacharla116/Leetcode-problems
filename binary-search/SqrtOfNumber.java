Problem Link: https://leetcode.com/problems/sqrtx/description/

Intuition:
  Binary Search on answer**

Solution:
class SqrtOfNumber {
    public int mySqrt(int x) {
        int sqrt = 0;

        long low = 1;
        long high = x;
        long mid;
        while(low <= high) {
            mid = (high-low)/2 + low;
            if(mid*mid <= x)  {
                sqrt = (int)mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return sqrt;
    }
}
