class Solution {
    public int longestPalindrome(String[] words) {
        int[][] dp = new int[26][26];
        int ans =0;
        for(String w : words){
            int a = w.charAt(0)-'a', b = w.charAt(1)-'a';
            if(dp[b][a]>0){
                ans+=4;
                dp[b][a]--;
            }else{
                dp[a][b]++;
            }
        }
             for (int i = 0; i < 26; i++) {
                 if (dp[i][i] > 0) {
                         ans += 2;
                         break;
                  }
    }
    return ans;
    }
}