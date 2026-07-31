class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int l =0;
        while(l<n){
            char t = s[l];
            s[l] = s[n-1];
            s[n-1] = t;
            l++;
            n--;
        }
    }
}