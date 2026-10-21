class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), result, candidates, target, 0);
        return result;
    }

    private void backtrack(List<Integer> currPath, List<List<Integer>> result, int[] nums, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        if (target < 0)
            return;

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > target)
                break;

            currPath.add(nums[i]);
            backtrack(currPath, result, nums, target - nums[i], i + 1);
            currPath.remove(currPath.size() - 1);
        }
    }
}