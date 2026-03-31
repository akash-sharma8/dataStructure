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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            List<Integer> currLevel = new ArrayList<>(currSize);
            for (int i = 0; i < currSize; i++) {
                if (!reverse) {
                    TreeNode currNode = queue.pollFirst();
                    currLevel.add(currNode.val);
                    if (currNode.left != null) {
                        queue.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.addLast(currNode.right);
                    }
                } else {
                    TreeNode currNode = queue.pollLast();
                    currLevel.add(currNode.val);
                    if (currNode.right != null) {
                        queue.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        queue.addFirst(currNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currLevel);
        }
        return result;
    }
}