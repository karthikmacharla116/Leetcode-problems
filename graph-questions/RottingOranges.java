Problem Link: https://leetcode.com/problems/rotting-oranges/description/

Intuition:
  BFS, Time complexity is O(N^2) + O(Vertices) and Space is O(Vertices)

Solution:
class RottingOranges {

    class Pair {
        int u;
        int v;
        public Pair(int u, int v){
            this.u = u;
            this.v = v;
        }

        // @Override
        // public String toString() {
        //     return " "+u+" "+v+" ";
        // }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int minutes[] = {-1};

        Queue<Pair> queue = new LinkedList();

        for(int row=0;row<m;row++) {
            for(int col=0;col<n;col++) {

                if(grid[row][col] == 2) {
                    queue.add(new Pair(row, col));    
                }
            }
        }
        bfs(queue, grid, minutes);
        //check if there are any fresh oranges.
        for(int row=0;row<m;row++) {
            for(int col=0;col<n;col++) {
                if(grid[row][col] == 1)
                    return -1;
            }
        }
        return minutes[0]>0?minutes[0]:0;
    }

    private void bfs(Queue<Pair> queue, int[][] grid, int[] minutes) {
        if(queue.isEmpty())
            return;
        int level = queue.size();
        // System.out.println(queue);
        while(level>0) {
            Pair pair = queue.poll();
            int row = pair.u;
            int col = pair.v;
            //making the 4-directionally adjacent oranges rotted
            boolean rotted1 = roteOranges(row-1, col, queue, grid);
            boolean rotted2 = roteOranges(row, col+1, queue, grid);
            boolean rotted3 = roteOranges(row+1, col, queue, grid);
            boolean rotted4 = roteOranges(row, col-1, queue, grid);
                
            level--;
        }
        minutes[0] += 1;
        bfs(queue, grid,minutes);
    }

    private boolean roteOranges(int row, int col, Queue<Pair> queue, int[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == 2)
            return false;

        grid[row][col] = 2; //rotted
        queue.add(new Pair(row, col));
        return true;
    }
}
