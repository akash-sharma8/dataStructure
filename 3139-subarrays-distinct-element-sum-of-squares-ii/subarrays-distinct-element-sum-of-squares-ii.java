class Solution {
    static final long MOD = 1_000_000_007L;
    int n ;
    long[] sum;
    long[] sq;
    long[] lazy; 
    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4*n];
        sq = new long[4*n];
        lazy = new long[4*n];

        int[] last = new int[100001];
        Arrays.fill(last,-1);
        long ans = 0;

        for(int i =0; i<n ; i++){
            int x = nums[i];
            int prev = last[x];
            update(1,0,n-1,prev+1,i);

            ans = (ans + sq[1])%MOD;
            last[x]  =i;            
        }
        return (int)ans;
    }  
    void apply(int node, int left, int right, long val) {
        long len = right - left + 1L;
        long oldSum = sum[node];

        sq[node] = (
            sq[node]
            + 2L * val % MOD * oldSum % MOD
            + len % MOD * val % MOD * val % MOD
        ) % MOD;

        sum[node] = (oldSum + len % MOD * val % MOD) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        long val = lazy[node];

        apply(node * 2, left, mid, val);
        apply(node * 2 + 1, mid + 1, right, val);

        lazy[node] = 0;
    }

    void update(
        int node, int left, int right,
        int ql, int qr
    ) {
        if (left > qr || right < ql) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}