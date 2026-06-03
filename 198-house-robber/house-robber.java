class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; 
        Arrays.fill(dp, -1);
        return robb(nums, 0,dp);
    }
    public int robb(int[] nums, int i,int[] dp){
        if(i>= nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
    
         return dp[i] = Math.max(nums[i] + robb(nums, i+2,dp), robb(nums,i+1,dp));
    }
}