class Solution {
    public boolean checkString(String s) {
        boolean ans = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a'){
                for(int j =0 ; j<i; j++){
                    if(s.charAt(j)=='b'){
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }
}