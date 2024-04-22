Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Intuition:
  DFS, Ancestor of a node means - PARENT node of that node. If you found p or q on left side of tree then we ignore the down part of it***

Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestor {
    TreeNode n;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        n= root;
        return dfs(root, p, q);
    }

    TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null)
            return node;
        
        if(node == p || node == q)
            return node;
        
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if(left != null && right != null)
            return node;
        return left != null?left:right;
    }
}
