Problem Link: https://leetcode.com/problems/number-of-provinces/description/

Intuition:
  DFS, AdjacencyList
  Time complexity: O(N^2) quadratic
  Space: O(N) for visited array, adjacency list

Solution:
class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        //create adjacency List from Matrix
        int n = isConnected.length;
        Map<Integer, List<Integer>> adjacencyList = new HashMap();

        for(int i=0;i<n;i++) {
            adjacencyList.put(i, new ArrayList());
        }

        //matrix to list
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        int[] visited = new int[n];
        int provinces = 0;
        //apply dfs
        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                provinces++;
                dfs(i, visited, adjacencyList);
            }
        }
        return provinces;
    }

    private void dfs(int node, int[] visited, Map<Integer, List<Integer>> adjacencyList) {
        if(visited[node] == 1)
            return;
        
        visited[node] = 1;

        for(Integer neighbour: adjacencyList.get(node)) {
            if(visited[neighbour] != 1)
                dfs(neighbour, visited, adjacencyList);
        }

    }
}
