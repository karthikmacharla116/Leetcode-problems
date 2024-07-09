Problem Link: https://leetcode.com/problems/average-waiting-time/description/?envType=daily-question&envId=2024-07-09

//Optimized, O(n) O(1)
class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        long avgTime = 0;

        int waitTime = 0; //customers[0][0];
        for(int[] customer: customers) {
            if(waitTime <= customer[0]){
                waitTime = customer[0];
            }
            waitTime += customer[1];
            avgTime += (waitTime - customer[0]);
        }
        return (double)avgTime/(double)customers.length ;
    }
}
