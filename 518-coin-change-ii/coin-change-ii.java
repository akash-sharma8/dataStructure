class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = changeCoin(amount, coins, dp, 0);
        return ans ;
    }

    private int changeCoin(int amount, int[] coins, int[][] dp, int i) {
        if (i == coins.length) {
            if(amount==0) return 1;
            else return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int skip = changeCoin(amount, coins, dp, i + 1);
        int take = 0;
        if (amount >= coins[i]) {
             take = changeCoin(amount - coins[i], coins, dp, i);
        }
        return dp[i][amount] = (skip+ take);
    }
}