Problem Link: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/?envType=daily-question&envId=2024-07-26

Solution:
class FindCityWithLessNeighbours {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Large value to represent infinity
        int INF = (int) 1e9 + 7;
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], INF); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
        }

        // Populate the matrix with initial edge weights
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            shortestPathMatrix[start][end] = weight;
            shortestPathMatrix[end][start] = weight; // For undirected graph
        }

        // Compute shortest paths from each city using Bellman-Ford algorithm
        for (int i = 0; i < n; i++) {
            bellmanFord(n, edges, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // Bellman-Ford algorithm to find shortest paths from a source city
    void bellmanFord(
        int n,
        int[][] edges,
        int[] shortestPathDistances,
        int source
    ) {
        // Initialize distances from the source
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE);
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Relax edges up to n-1 times
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];
                // Update shortest path distances if a shorter path is found
                if (
                    shortestPathDistances[start] != Integer.MAX_VALUE &&
                    shortestPathDistances[start] + weight <
                    shortestPathDistances[end]
                ) {
                    shortestPathDistances[end] = shortestPathDistances[start] +
                    weight;
                }
                if (
                    shortestPathDistances[end] != Integer.MAX_VALUE &&
                    shortestPathDistances[end] + weight <
                    shortestPathDistances[start]
                ) {
                    shortestPathDistances[start] = shortestPathDistances[end] +
                    weight;
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}
