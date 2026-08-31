class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int n = nodes.length;
        int nE = 1;
        for (int i = 0; i < n; ++i) {
            if (nodes[i].equals("#")) {
                nE--;
                if (nE == 0) {
                    return i == n - 1;
                }
            } else {
                nE++;
            }
        }
        return false;
    }
}