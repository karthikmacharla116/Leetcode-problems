Problem Link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/?envType=daily-question&envId=2024-07-08

Solution: O(n), O(1)
class FindWinnerInCircularGame {
    public int findTheWinner(int n, int k) {
        int winner = 0;

        for(int i=2;i<=n;i++) {
            winner  = (winner+k)%i;
        }
        return winner+1;
    }
}

//recursion
class Solution {
    public int findTheWinner(int n, int k) {
        
        return recursion(n,k)+1;
    }

    int recursion(int n, int k) {
        if(n == 1)
            return 0; 
        
        return (recursion((n-1),k)+k)%n;
    }
}

//Using queue
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList();
        for(int i=1;i<=n;i++)
            queue.add(i);
        return recursion(queue, k);
    }

    int recursion(Queue<Integer> queue, int k) {
        if(queue.size() == 1)
            return queue.poll();
        
        int loop = k-1;
        while(loop>0) {
            int person = queue.poll();
            queue.add(person);
            loop--;
        }
        queue.poll();
        
        return recursion(queue, k);
    }
}
