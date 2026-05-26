class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = 0;
        int k =0;
        int[] arr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i>=0; i--){
            stack.push(nums[i]);

        }
        for(int i = nums.length-1; i>=0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek()<= nums[i]){
                stack.pop();
            }
            if(stack.size()==0){
                arr[i] = -1;
            }else{
                arr[i] = stack.peek();
            }
            stack.push(nums[i]);

        }
        
        return arr;
    }
}