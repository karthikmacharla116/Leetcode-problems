Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

Intuition:
  Height of the Root node, DFS, Post-Order Traversal

Solution:
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
class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        //Post-Order Traversal
        return dfs(root);
    }

    int dfs(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(dfs(node.left), dfs(node.right))+1;
    }
}
