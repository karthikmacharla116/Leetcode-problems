Problem Link: https://leetcode.com/problems/surrounded-regions/description/

Intuition:
  Apply DFS to all corners of matrix having 'O', where these corner 'O' s and its adjacent are cannot be flipped to 'X'.

Solution:
class SurroundedRegionsXO {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int row=0;row<m;row++) {
            for(int col = 0;col<n;col++) {
                if(row == 0 || row == m-1) {
                    dfs(row, col, board, visited);
                }
                if(col == 0 || col == n-1) {
                    dfs(row, col, board, visited);
                }
            }
        }


        for(int row=0;row<m;row++) {
            for(int col=0;col<n;col++) {
                if(visited[row][col])
                    board[row][col] = 'O';
                else
                    board[row][col] = 'X';
            }
        }

    }

    void dfs(int row, int col, char[][] board, boolean[][] visited) {
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] == 'X' || visited[row][col])
            return;
        
        visited[row][col] = true;
        dfs(row-1, col, board, visited);
        dfs(row, col+1, board, visited);
        dfs(row+1, col, board, visited);
        dfs(row, col-1, board, visited);
    }
}
