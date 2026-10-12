class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            boolean alreadyAdded = false;
            for (int m = 0; m < k; m++) {
                if (temp[m] == nums1[i]) {
                    alreadyAdded = true;
                    break;
                }
            }
            if (alreadyAdded)
                continue;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    temp[k++] = nums1[i];
                    break;
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}