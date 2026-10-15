class Solution {

    // we have to make subarrays and count tyhe distinct value of that subarray and return the sum of sqaure of that counting subarray
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sumOfProduct =0;
        for(int i = 0; i<n ; i++){
                Set<Integer> set = new HashSet<>();
            for(int j = i; j<n;j++){

                    set.add(nums.get(j));

 
                int count = set.size();
                sumOfProduct += count*count;
            }
        }
        return sumOfProduct;
    }
}