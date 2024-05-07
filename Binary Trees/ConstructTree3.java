Problem Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

Intuition:
  Easy, DFS, BST

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
class ConstructTree3 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++) {
            helper(node, preorder[i]);
        }
        return node;
    }

    TreeNode helper(TreeNode node, int value) {
        if(node == null) {
            return new TreeNode(value);
        }
        
        if(value < node.val) {
            node.left = helper(node.left, value);
        } 
        if(value > node.val) {
            node.right = helper(node.right, value);
        }
        return node;

    }

}
