Problem Link: https://leetcode.com/problems/is-graph-bipartite/description/

Intuition: 
  Can be solved using BFS, DFS. Handle disconnected graphs.

Solution: DFS
class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        
        Map<Integer, List<Integer>> adjList = new HashMap();

        for(int i=0;i<graph.length;i++) {
            adjList.put(i, Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
        }
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        //visited[0] = 0;

        //To handle all connected components(provinces)
        for(int node = 0; node<graph.length;node++) {
            if(visited[node] == -1) {
                visited[node] = 0;
                if(!dfs(node, adjList, visited)) {
                    return false; //not bipartite graph
                }
            }
        }
        return true;
    }

    boolean dfs(int node, Map<Integer, List<Integer>> adjList, int[] visited) {
        
        for(int n: adjList.get(node)) {
            if(visited[n] == -1) {
                visited[n] = 1 - visited[node];
                if(!dfs(n, adjList, visited)) {
                    return false;
                }
            } else if(visited[n] == visited[node]) {
                return false;
            }
        }
        return true;
    }
}


//Using BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Map<Integer, List<Integer>> adjList = new HashMap();

        for(int i=0;i<graph.length;i++) {
            adjList.put(i, Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
        }
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList();

        //To handle all connected components(provinces)
        for(int node = 0; node<graph.length;node++) {
            if(visited[node] == -1) {
                visited[node] = 0;
                queue.add(node);
                if(!bfs(queue, adjList, visited)) {
                    return false; //not bipartite graph
                }
            }
        }
        return true;
    }

    boolean bfs(Queue<Integer> queue, Map<Integer, List<Integer>> adjList, int[] visited) {
        if(queue.isEmpty())
            return true;
        int level = queue.size();

        while(level > 0) {
            int node = queue.poll();
            for(int n: adjList.get(node)) {
                if(visited[n] == -1) {
                    visited[n] = 1 - visited[node];
                    queue.add(n);
                } else if(visited[n] == visited[node]) {
                    return false;
                }
            }
            level--;
        }
        return bfs(queue, adjList, visited);
    }
}

