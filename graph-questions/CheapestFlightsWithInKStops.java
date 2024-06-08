Problem Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

Intuition:
  Dijkstra's Algorithm, BFS, Queue
Solution:
class CheapestFlightsWithInKStops {

    class Pair {
        int stop;
        int cost;
        
        public Pair(int stop, int cost) {
            this.stop = stop;
            this.cost = cost;
        }

        // @Override
        // public String toString() {
        //     return " "+this.stop +" "+this.cost;
        // }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<Pair>> adj = new HashMap();

        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.computeIfAbsent(from, (key)-> new ArrayList()).add(new Pair(to, price));
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        Queue<int[]> queue = new LinkedList(); //[stopsCount, currentStop, cost]
        queue.add(new int[]{0,src,0});
        bfs(queue, adj, prices, k);

        return (prices[dst] == Integer.MAX_VALUE)?-1:prices[dst];
    }

    void bfs(Queue<int[]> queue, Map<Integer, List<Pair>> adj, int[] prices, int maxStops) {
        if(queue.isEmpty())
            return;
        
        int level = queue.size();

        while(level > 0) {
            int[] arr = queue.poll();
            int stopsCnt = arr[0];
            int current = arr[1];
            int price = arr[2];

            //check the stops count
            if(stopsCnt > maxStops)
                return;


            //next stops
            if(adj.containsKey(current)) {
                for(Pair pair: adj.get(current)) {
                    int next = pair.stop;
                    int cost = pair.cost;

                    if(price+cost < prices[next]) {
                        prices[next] = price+cost;
                        queue.add(new int[]{stopsCnt+1, next, prices[next]});
                    }
                }
            }
            level--;
        }
        bfs(queue, adj, prices, maxStops);
    }
}
