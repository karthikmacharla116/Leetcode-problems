Problem Link: https://leetcode.com/problems/01-matrix/description/

Intuition:
  Apply BFS on multi-source i.e add all the (row, col) of Zeros initially and check 4-directionally

Solution:
class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];

        //BFS
        Queue<int[]> queue = new LinkedList();

        for(int row=0;row<m;row++) {
            for(int col=0;col<n;col++) {
                if(mat[row][col] == 0) {
                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        int[][] result = new int[m][n];
        bfs(queue, mat, result, 0, visited);
        return result;
    }
    void bfs(Queue<int[]> queue, int[][] mat, int[][] ans, int distance, boolean[][] visited) {
        if(queue.isEmpty())
            return;
        
        int level = queue.size();
        while(level > 0) {
            int[] value = queue.poll();
            int row = value[0];
            int col = value[1];
            
            ans[row][col] = distance;
            neighbours(row-1, col, mat, queue, visited);
            neighbours(row, col+1, mat, queue, visited);
            neighbours(row+1, col, mat, queue, visited);
            neighbours(row, col-1, mat, queue, visited);
            level--;
        }
        bfs(queue, mat, ans, distance+1,  visited);
    }

    void neighbours(int row, int col, int[][] mat, Queue<int[]> queue, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] == 0 || visited[row][col])
            return;
        queue.add(new int[]{row,col});
        visited[row][col] = true;
    }
}
