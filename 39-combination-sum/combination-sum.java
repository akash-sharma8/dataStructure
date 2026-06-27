class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(new ArrayList<>(), nums , target, 0 );
        return result;
    }
    private void backtrack(List<Integer> currPath , int[] nums , int target, int index){
        if(target==0){
            result.add(new ArrayList<>(currPath));
            return ;
        }

        if(target<0) return ;

        for(int i = index; i<nums.length; i++){
            currPath.add(nums[i]);
            backtrack(currPath, nums , target-nums[i],i);
            currPath.remove(currPath.size() - 1);
        }
    }
}