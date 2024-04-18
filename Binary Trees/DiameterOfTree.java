Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/description/

Intuition:
  Depth First Search, finding the height of left, right child of node

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
class DiameterOfTree {
    int diameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    
    int height(TreeNode node) {
        if(node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        int dia = leftHeight+rightHeight+1;
        diameter = Math.max(diameter, dia);
        return Math.max(leftHeight, rightHeight)+1;
    }
    
}
