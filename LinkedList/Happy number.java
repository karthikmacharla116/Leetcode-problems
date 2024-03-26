Problem Link: https://leetcode.com/problems/happy-number/description/

Intuition:
  Google question,
  Visualize the values(sum of squares) into LinkedList.
  Apply fast & slow pointers.


Solution:
class HappyNumber {
    public boolean isHappy(int n) {
        
        int slow = find(n);
        int fast = find(find(slow));

        if(slow == 1 || fast == 1) 
            return true;

        while(fast != slow) {
            slow = find(slow);
            fast = find(find(fast));
            if(fast == 1)
                return true;
        }

        return false;
    }

    private int find(int n) {
        int sum = 0;
        while(n>0) {
            sum = sum + (n%10)*(n%10);
            n = n/10;
        }
        return sum; 
    }
}
