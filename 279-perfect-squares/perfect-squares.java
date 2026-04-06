// Mathematical solution using Lagrange + Legendre theorems
// Time - O(√n)
// Space - O(1)
class Solution {
    public int numSquares(int n) {

        // Case 1: Perfect square
        if (isPerfectSquare(n)) return 1;

        // Remove factors of 4
        int temp = n;
        while ((temp & 3) == 0) temp >>= 2;

        // Case 2: If n = 4^k * (8m + 7), answer is 4
        if ((temp & 7) == 7) return 4;

        // Case 3: Check if sum of two squares
        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i)) return 2;
        }

        // Otherwise answer must be 3
        return 3;
    }

    private boolean isPerfectSquare(int x) {
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }
}