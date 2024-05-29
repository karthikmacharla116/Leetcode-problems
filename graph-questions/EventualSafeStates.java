problem Link: https://leetcode.com/problems/find-eventual-safe-states/description/

Intuition:
  Can be solved using Cycle detection in a Directed graph. DFS, Check for all un-visited nodes.
  Time O(V) + O(V + edges) and space O(N+N)

  Also, using BFS - Topological sort.
    -By reversing the edge directions and calculating the indegrees,...

Solutions:

//use dfs
class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> adjList = new HashMap();
        
        for(int i=0;i<graph.length;i++) {
            adjList.put(i, Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
        }

        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        
        List<Integer> safeNodes = new ArrayList();

        for(int node=0;node<n;node++) {
            //Arrays.fill(visited, 0);
            System.out.println(Arrays.toString(visited));
            System.out.println("path " +Arrays.toString(pathVisited));
            if(!dfs(node, adjList, visited, pathVisited)) {
                
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }

    boolean dfs(int node, Map<Integer, List<Integer>> adjList, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int n: adjList.get(node)) {
            if(visited[n] == 0) {
                if(dfs(n, adjList, visited, pathVisited)) {
                    return true;
                }
            } else if(visited[n] == 1 && pathVisited[n] == 1)
                return true;
        }
        pathVisited[node] = 1-pathVisited[node];
        return false;
    }
}

================== Striver's approach ==================

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> adjList = new HashMap();

        for(int i=0;i<n;i++) {
            adjList.put(i, Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        int[] checked = new int[n];

        for(int node=0;node<n;node++) {
            if(!visited[node])
                dfs(node, adjList, visited, pathVisited, checked);
        }  

        List<Integer> safeList = new ArrayList();
        for(int i=0;i<n;i++) {
            if(checked[i] == 1)
                safeList.add(i);
        }
        return safeList;
    }

    boolean dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited, boolean[]  pathVisited, int[] checked) {
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int n: adj.get(node)) {
            if(!visited[n]) {
                if(dfs(n, adj, visited, pathVisited, checked))
                    return true;
            } else if(pathVisited[n]) {
                return true; //found cycle
            }
        }

        pathVisited[node] = false;
        checked[node] = 1;
        return false;
    }
}


//Using BFS - Topological sort
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        //reverse the edge directions
        Map<Integer, List<Integer>> adj = new HashMap();

        //By using Topological sorting
        int[] indegree = new int[n];

        for(int i=0;i<n;i++) {
            for(int node: graph[i]) {
                adj.computeIfAbsent(node, (k)-> new ArrayList()).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList();
        for(int node=0;node<n;node++) {
            if(indegree[node] == 0)
                queue.add(node);
        }
        List<Integer> list = new ArrayList();
        bfs(queue, adj, indegree, list);
        Collections.sort(list);
        return list;
    }


    void bfs(Queue<Integer> queue, Map<Integer, List<Integer>> adj, int[] indegree, List<Integer> list) {
        if(queue.isEmpty())
            return;
        
        int level = queue.size();

        while(level > 0) {
            int node = queue.poll();
            list.add(node);
            if(adj.get(node) != null) {
                for(int n: adj.get(node)) {
                    indegree[n]--;
                    if(indegree[n] == 0)
                        queue.add(n);
                }
            }
            level--;
        }
        bfs(queue, adj, indegree, list);
    }
}
