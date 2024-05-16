Problem Link: https://leetcode.com/problems/flood-fill/description/

Intuition:
  DFS and time complexity is O(N)

Solution:
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int filledColor = image[sr][sc]; 
        dfs(image, sr, sc, filledColor, color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int value) {
        if(row < 0 || col < 0 || row >=image.length || col >= image[0].length || image[row][col] != color || image[row][col] == value)
            return;
        
        image[row][col] = value;
        dfs(image, row-1, col, color, value);
        dfs(image, row, col+1, color, value);
        dfs(image, row+1, col, color, value);
        dfs(image, row, col-1, color, value);
    }
}
