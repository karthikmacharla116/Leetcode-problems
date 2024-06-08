Problem Link: https://leetcode.com/problems/path-with-minimum-effort/description/

Intuition:
  Dijkstra's Algorithm, PriorityQueue(min Heap), BFS, always update the distance array with max-effort taken in the path 

Solution:
class PathWithMinEffort {

    class Pair implements Comparable<Pair> {
        int abs;
        int x;
        int y;

        public Pair(int abs, int x, int y) {
            this.abs = abs;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.abs, other.abs);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] distance = new int[m][n];

        for(int[] arr: distance)
            Arrays.fill(arr, Integer.MAX_VALUE);
        distance[0][0] = 0;
        
        PriorityQueue<Pair> minHeap = new PriorityQueue();
        minHeap.add(new Pair(0, 0, 0));

        return bfs(minHeap, distance, heights);
    }

    int bfs(PriorityQueue<Pair> minHeap, int[][] distance, int[][] height) {

        while(!minHeap.isEmpty()) {
            Pair pair  = minHeap.poll();
            int absDiff = pair.abs;
            int x = pair.x;
            int y = pair.y;
            if(x == height.length-1 && y == height[0].length-1)
                return distance[x][y];

            int value = height[x][y];
            isSafe(x, y+1, value, absDiff, minHeap, distance, height);
            isSafe(x+1, y, value, absDiff, minHeap, distance, height);
            isSafe(x, y-1, value, absDiff, minHeap, distance, height);
            isSafe(x-1, y, value, absDiff, minHeap, distance, height);
        }
        return distance[height.length-1][height[0].length-1];
    }

    void isSafe(int x, int y, int value, int abs, PriorityQueue<Pair> minHeap, int[][] distance, int[][] height) {
        if(x < 0 || y < 0 || x >= height.length || y >= height[0].length)
            return;
        int newEffort = Math.max(Math.abs(height[x][y] - value), abs);
        if(newEffort < distance[x][y]) {
            distance[x][y] = newEffort;
            minHeap.add(new Pair(distance[x][y], x, y));
        }
    }

}
