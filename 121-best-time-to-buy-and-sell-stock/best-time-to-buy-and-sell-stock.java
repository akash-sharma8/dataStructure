class Solution {
    public int maxProfit(int[] prices) {
        // int max = Integer.MIN_VALUE;
        int n = prices.length;
        // for(int i =0; i<n ; i++){
        //     for(int j =i; j<n ; j++){
        //         max = Math.max(max, prices[j]-prices[i]);
        //     }
        // }

        //optimised

    int buy = prices[0];
    int profit = 0;
    for(int i =0; i<n;i++){
        if(prices[i]<buy){
            buy = prices[i];
        }else if(prices[i]-buy>profit){
            profit =prices[i]-buy;
        }
    }
        return profit;
    }
}