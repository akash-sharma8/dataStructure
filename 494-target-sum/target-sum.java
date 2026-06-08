class Solution {
        int sum =0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int num :nums) sum+=num;
        int[][] dp = new int[nums.length][2*sum+1];
        for(int i =0; i<nums.length; i++)
            for(int j =0 ; j<dp[0].length; j++) dp[i][j] = -1;

        
        return findTarget(nums, target, 0,0, dp);
    }
    public int findTarget(int[] nums, int target, int i, int res ,int[][] dp){

        if(i == nums.length){
             if(res== target) return 1;
             else return 0;
        }
        
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];

        int sub = findTarget(nums, target, i+1, res-nums[i] , dp);
        int add = findTarget(nums, target, i+1, res+nums[i], dp);
        return dp[i][res+sum] = sub+add;
    }
}