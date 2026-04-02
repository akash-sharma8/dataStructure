/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       return  populatedSorted(nums, 0, nums.length);
    }

    private TreeNode populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = populatedSorted(nums, start, mid);
        node.right = populatedSorted(nums, mid + 1, end);
        return node;
    }
}