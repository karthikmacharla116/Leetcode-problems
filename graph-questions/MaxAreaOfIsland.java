Problem Link: https://leetcode.com/problems/max-area-of-island/description/

Intuition:
  DFS, similar to Island questions

Solution:
class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int row=0;row<m;row++) {
            for(int col=0;col<n;col++) {

                if(grid[row][col] == 1) {
                    int[] a = {0};
                    dfs(row, col, grid, a);
                    area = Math.max(area, a[0]);
                }
            }
        }
        return area;
    }

    private void dfs(int row, int col, int[][] grid, int[] area) {
        if(row < 0 || col < 0 || row >= grid.length || col >=grid[0].length || grid[row][col] == 0)
            return;
        
        grid[row][col] = 0;
        area[0] += 1;

        dfs(row-1, col, grid, area);
        dfs(row, col+1, grid, area);
        dfs(row+1, col, grid, area);
        dfs(row, col-1, grid, area);
    }

}
