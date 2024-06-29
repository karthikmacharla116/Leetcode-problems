Problem Link: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-06-29

Intuition:
  BFS, Topological Sort, In-Degrees of node, ancestors of node

Solution:
class AncestorsOfNode {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList());

        //indegree
        int[] inDegree = new int[n];
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        List<Set<Integer>> result = new ArrayList();
        //add empty lists into answer
        for(int i=0;i<n;i++)
            result.add(new TreeSet());

        //BFS
        Queue<Integer> queue = new LinkedList();
        //Add all the xero In-degree nodes to queue
        for(int i=0;i<n;i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }
        bfs(queue, adj, inDegree, result);

        List<List<Integer>> answer = new ArrayList();
        for(int i=0;i<n;i++)
            answer.add(new ArrayList(result.get(i)));
        return answer;
    }

    void bfs(Queue<Integer> queue, List<List<Integer>> adj, int[] inDegree, List<Set<Integer>> answer) {
        if(queue.isEmpty())
            return;
        
        int level = queue.size();

        while(level > 0) {
            int node = queue.poll();
            //Anscestors
            Set<Integer> all = answer.get(node);
            for(int n: adj.get(node)) {
                answer.get(n).addAll(all);
                answer.get(n).add(node);
                
                // Decrease the in-degree of the neighbor
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    queue.offer(n);
                }

            }

            level--;
        }
        bfs(queue, adj,inDegree, answer);
    }
}
