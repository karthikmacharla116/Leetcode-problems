Problem Link: https://leetcode.com/problems/invert-binary-tree/description/

Intuition:
  DFS, swaping nodes
  
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
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        dfs(root);
        return root;
    }

    void dfs(TreeNode node) {
        if(node == null)
            return;
        
        dfs(node.left);
        dfs(node.right);
        TreeNode swap = node.left;
        node.left = node.right;
        node.right = swap;
    }
}
