Problem Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

Intuition:
  Dijkstra's ALgorithm, PriorityQueue, BFS, distance array(relaxation)

Solution:
class ShortestPathBinaryMatrix {

    class Pair implements Comparable<Pair>{
        int weight;
        int x;
        int y;
        public Pair(int weight, int x, int y) {
            this.weight = weight;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.valueOf(this.weight).compareTo(other.weight);
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        //dijkstra's Algorithm
        int n = grid.length;

        //source & destination is ALWAYS same. (0,0) and (n-1,n-1)
        int[][] distance = new int[n][n];
        for(int[] arr: distance)
            Arrays.fill(arr, Integer.MAX_VALUE);
        distance[0][0] = 1;

        PriorityQueue<Pair> minHeap = new PriorityQueue();
        minHeap.add(new Pair(1,0,0));
        
        bfs(minHeap, grid, distance);
        // for(int[] arr: distance)
        //     System.out.println(Arrays.toString(arr));
        
        
        return distance[n-1][n-1] != Integer.MAX_VALUE ? distance[n-1][n-1]: -1;
    }

    void bfs(PriorityQueue<Pair> minHeap, int[][] grid, int[][] distance) {
        if(minHeap.isEmpty())
            return;

        int level = minHeap.size();
        while(level > 0) {
            Pair pair = minHeap.poll();
            int weight = pair.weight;
            int x = pair.x;
            int y = pair.y;

            isSafe(x,y+1, weight, grid.length, minHeap, distance, grid);
            isSafe(x+1,y+1, weight, grid.length, minHeap, distance, grid);
            isSafe(x+1,y, weight, grid.length, minHeap, distance, grid);
            isSafe(x+1,y-1, weight, grid.length, minHeap, distance, grid);
            isSafe(x,y-1, weight, grid.length, minHeap, distance, grid);
            isSafe(x-1,y-1, weight, grid.length, minHeap, distance, grid);
            isSafe(x-1,y, weight, grid.length, minHeap, distance, grid);
            isSafe(x-1,y+1, weight, grid.length, minHeap, distance, grid);

            level--;
        }
        bfs(minHeap, grid, distance);
    }

    void isSafe(int x, int y, int weight, int n, PriorityQueue<Pair> minHeap, int[][] distance, int[][] grid) {
        if(x < 0 || y < 0 || x>=n || y >= n || grid[x][y] == 1)
            return;
        
        if(weight + 1 < distance[x][y]) {
            // System.out.println("For x y "+x+" "+y+" weight "+(weight+1));
            distance[x][y] = weight+1;
            minHeap.add(new Pair(distance[x][y], x, y));
        }
    }
}
