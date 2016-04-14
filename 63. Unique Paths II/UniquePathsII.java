public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        if(m==0||n==0)
            return 0;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++)
        {
            if(obstacleGrid[i][0]!=1){
                dp[i][0]=1;
            }
            else{
                dp[i][0]=0;
                break;
            }
        }
        for(int j=0;j<n;j++)
        {
            if(obstacleGrid[0][j]!=1){
                dp[0][j]=1;
            }
            else{
                dp[0][j]=0;
                break;
            }
        }
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        return dp[m-1][n-1];
    }
}