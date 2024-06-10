Problem Link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

Intuition:
  Dijkstra's Algorithm, BFS, PriorityQueue tracking the no.of ways for each node

Solution:
class NoOfWaysToArriveDestination {

    class Pair implements Comparable<Pair> {
        long time;
        int intersection;
        
        public Pair(long time, int intersection) {
            this.time = time;
            this.intersection = intersection;
        }

        @Override
        public int compareTo(Pair pair) {
            return Long.compare(this.time, pair.time);
        }

    }

    public int countPaths(int n, int[][] roads) {
        if(roads.length == 0)
            return 1;
        
        Map<Integer, List<Pair>> adj =  new HashMap();

        for(int[] road: roads) {
            adj.computeIfAbsent(road[0], (k)-> new ArrayList()).add(new Pair(road[2], road[1]));
            adj.computeIfAbsent(road[1], (k)-> new ArrayList()).add(new Pair(road[2], road[0]));
        }

        //Dijkstra's Algorithm
        PriorityQueue<Pair> minHeap = new PriorityQueue();
        minHeap.add(new Pair(0, 0));

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        //Tracking no.of ways array
        int[] ways = new int[n];
        ways[0] = 1; //For starting node there is only one way.

        int mod = (int)(1e9+7);
        bfs(minHeap, adj, distance, ways, mod);

        return ways[n-1]%mod;
    }

    void bfs(PriorityQueue<Pair> minHeap, Map<Integer, List<Pair>> adj, long[] distance, int[] ways, int mod) {
        
        while(!minHeap.isEmpty()) {
            int level = minHeap.size();
            Pair pair = minHeap.poll();
            int intersection = pair.intersection;
            long time = pair.time;

            for(Pair p : adj.get(intersection)) {
                int itrsection = p.intersection;
                long t = p.time;

                if(time + t < distance[itrsection]) {
                    distance[itrsection] = time+t;
                    ways[itrsection] = ways[intersection];
                    minHeap.add(new Pair(distance[itrsection], itrsection));
                } else if(time + t == distance[itrsection]) {
                    ways[itrsection] = (ways[itrsection]+ways[intersection])%mod;
                }
            }
        }

    }

}
