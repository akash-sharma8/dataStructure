class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        int fact = 1;
        for(int i = 1 ; i<n;i++){
            fact*=i;
        }
        for(int i = 1; i<=n;i++){
            ans.add(i);
        }
        k--;

        StringBuilder res = new StringBuilder();

        while(true){
            res.append(ans.get(k/fact));
            ans.remove(k/fact);
            if(ans.isEmpty()) break;
            k%=fact;
            fact/=ans.size();
        }
        return res.toString();
    }
}

// k-- — zero-based indexing ke liye.
// k / fact — next digit ka index.
// k % fact — us block ke andar remaining position.
// nums.remove(index) — chosen digit ko dobara use hone se rokta hai.
// fact /= nums.size() — agle block ka size calculate karta hai.