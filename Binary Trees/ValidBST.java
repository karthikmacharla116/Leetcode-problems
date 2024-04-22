Problem Link: https://leetcode.com/problems/validate-binary-search-tree/description/

Intuition:
  DFS, low, high values for a node

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
class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    boolean dfs(TreeNode node, Integer low, Integer high) {
        if(node == null)
            return true;
        
        if(low != null && node.val <= low)
            return false;
        if(high != null && node.val >= high)
            return false;
        return dfs(node.left, low, node.val) && dfs(node.right, node.val, high);
    }
}
