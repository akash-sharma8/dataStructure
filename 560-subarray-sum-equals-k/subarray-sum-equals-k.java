class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum =0;
        int noOfSubArray = 0;
        map.put(0,1);
        for(int i =0; i<nums.length; i++){
            prefixSum+=nums[i];

            int removed = prefixSum-k;
            if(map.containsKey(removed)){
                noOfSubArray+=map.get(removed);
            }
            map.put(prefixSum , map.getOrDefault(prefixSum , 0)+1);
        }
        return noOfSubArray;
    }
}