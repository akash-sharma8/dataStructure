class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
      
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
        if(s[0].equals("0")) return "0";

        for(String sm: s){
            sb.append(sm);
        }

        return sb.toString();

    }
}