public class Solution {
    public String encode(String s) {
        if(s == null || s.length() == 0)
            return "";
        String[][] dp = new String[s.length()][s.length()];
        for(int l = 0; l < s.length(); l++)
        {
            for(int i = 0; i < s.length() - l; i++)
            {
                int j = i + l;
                String substr = s.substring(i, j + 1);
                dp[i][j] = substr;
                if(j - i < 4)
                {
                    continue;
                }
                for(int k = i; k < j; k++)
                {
                    if((dp[i][k] + dp[k + 1][j] ).length() < dp[i][j].length())
                    {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
                
                for(int k = 0; k < substr.length(); k++)
                {
                    String current = substr.substring(0, k + 1);
                    if(current!= null && substr.length() % current.length() == 0 && substr.replaceAll(current, "").length() == 0 )
                    {
                        String ss = substr.length() / current.length() + "[" + dp[i][ i + k] +"]"; 
                        if(ss.length() < dp[i][j].length())
                        {
                            dp[i][j] = ss;
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}