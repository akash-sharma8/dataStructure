class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
           
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        List<Integer> majorityElements = new ArrayList<>();
        int max = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            if (count > max) {
                majorityElements.add(element);
            }
        }
        return majorityElements;
    }
}