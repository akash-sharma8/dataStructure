class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i =0 ; i<n; i++){
            dp[i][i] = piles[i];
        }

        for(int i = 2 ; i<=n; i++){
            for(int j= 0; j<n-i+1; j++){
                int k = i+j-1;
                dp[j][k] = Math.max(piles[j] - dp[j+1][k], piles[k] - dp[j][k-1]);
            }
        }

  return dp[0][n-1]>0;
    }
}