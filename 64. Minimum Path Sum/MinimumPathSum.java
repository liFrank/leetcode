public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] path = new int[row][col];
        //for(int i = 0; i < row; i ++)
        //    for(int j = 0; j < col; j++)
        //        path[i][j] = Integer.MAX_VALUE;
        path[0][0] = grid[0][0];
        for(int i = 1; i < row; i++)
        {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < col; i++)
        {
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col ; j++)
            {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1] ) + grid[i][j];
            }
        }
        return path[row - 1][col - 1];
    }
}