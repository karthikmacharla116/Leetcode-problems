Problem Link: https://leetcode.com/problems/cousins-in-binary-tree/

Intuition:
  Solves easily by finding the levels and relation(siblings)

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
class CousinsInTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xNode = findNode(root, x);
        TreeNode yNode = findNode(root, y);
        
        return (
            (level(root, xNode, 0) == level(root, yNode, 0)) && (!isSibling(root, xNode, yNode))
        );
    }
    
    TreeNode findNode(TreeNode node, int value) {
        if(node == null)
            return null;
        
        if(node.val == value)
            return node;
        
        TreeNode n = findNode(node.left, value);
        if(n != null)
            return n;
        return findNode(node.right, value);
    }
    
    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if(node == null)
            return false;
        
        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
            );
    }
    
    int level(TreeNode node, TreeNode x, int level) {
        if(node == null)
            return 0;
        
        if(node == x)
            return level;
        
        int l = level(node.left, x, level+1);
        if(l != 0)
            return l;
        return level(node.right, x, level+1);
    }
    
}

