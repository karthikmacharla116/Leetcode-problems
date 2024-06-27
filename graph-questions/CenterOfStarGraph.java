Problem Link: https://leetcode.com/problems/find-center-of-star-graph/description/?envType=daily-question&envId=2024-06-27

Solution: Optimized O(1) time and O(1) space
class CenterOfStarGraph {
    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])?edges[0][0]:edges[0][1];
    }
}

//Brute Force
class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap();

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.computeIfAbsent(u, (k) -> new ArrayList()).add(v);
            adjacencyList.computeIfAbsent(v, (k) -> new ArrayList()).add(u);
        }
        int node1 = edges[0][0];
        int node2 = edges[0][1];
        //a star node will have n-1 edges
        boolean isStar = (adjacencyList.get(node1).size() == edges.length);

        if(isStar)
            return node1;

        return node2;
    }
}
