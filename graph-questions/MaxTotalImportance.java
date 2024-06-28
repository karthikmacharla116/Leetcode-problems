Problem Link: https://leetcode.com/problems/maximum-total-importance-of-roads/?envType=daily-question&envId=2024-06-28

Intuition:
  Heap(PriorityQueue), 

Solution: Optimized
class MaxTotalImportance {
    public long maximumImportance(int n, int[][] roads) {

        //indegree
        long[] degree = new long[n];

        for(int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);
        long maxImp = 0;
        for(int i=0;i<n;i++) {
            maxImp += (degree[i]*(i+1));
        }        
        return maxImp;
    }
}

//Brute Force
class Solution {
    public class Pair{
        int node;
        int degree;

        Pair(int node,int degree){
            this.node=node;
            this.degree=degree;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->-x.degree+y.degree);
        for(int i=0;i<n;i++)
        {
            pq.add(new Pair(i,adj.get(i).size()));
        }
        int nums[]=new int[n];
        int val=n;
        for(int i=0;i<n;i++)
        {
            Pair p=pq.peek();
            pq.remove();
            nums[p.node]=val--;
        }
        
        Long totalImp=(long)0;
        for(int i=0;i<roads.length;i++)
        {
            int node1=roads[i][0];
            int node2=roads[i][1];
            totalImp+=nums[node1]+nums[node2];
        }
        return totalImp;
    }
}
