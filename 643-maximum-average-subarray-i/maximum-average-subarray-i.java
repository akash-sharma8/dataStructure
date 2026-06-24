class Solution {
    public double findMaxAverage(int[] nums, int k) {
         double sum = 0;
        
            for(int j =0 ; j<k; j++){
                sum+= nums[j];
            }
              double maxSum = sum;

            for(int i =k; i<nums.length; i++){
             sum = sum - nums[i-k] + nums[i];
             maxSum = Math.max(maxSum,sum);
        }
        return maxSum/k;
    }
}