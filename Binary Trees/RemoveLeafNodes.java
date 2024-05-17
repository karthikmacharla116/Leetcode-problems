Problem Link: https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17

Intuition:
  DFS

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
class RemoveLeafNodes {
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return dfs(root, target);
    }

    TreeNode dfs(TreeNode node, int target) {
        if(node == null)
            return node;
        
        if(node.left == null && node.right == null) {
            if(node.val == target)
                return null;
            return node;
        }

        node.left = dfs(node.left, target);
        node.right = dfs(node.right, target);

        if(node.val == target) {
            if(node.left == null && node.right == null)
                return null;
        }

        return node;
    }
}
