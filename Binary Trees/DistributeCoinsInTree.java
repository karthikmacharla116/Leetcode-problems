Problem Link: https://leetcode.com/problems/distribute-coins-in-binary-tree/description/?envType=daily-question&envId=2024-05-18

Intuition:
  Tricky DFS, Watch Aryan mittal's episode

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
class DistributeCoinsInTree {
    public int distributeCoins(TreeNode root) {
        int[] count = {0};
        dfs(root, root.val, count);
        return count[0];
    }

    int dfs(TreeNode node, int coins, int[] count) {
        if(node == null)
            return 0;
        node.val += dfs(node.left, node.val, count);
        node.val += dfs(node.right, node.val, count);

        if(node.val > 1) {
            count[0] += (node.val-1);
            return node.val-1;
        } else if(node.val == 0) { //child node required 1 coin from its parent
            count[0] += 1;
            return -1; //keeping one coin
        } else if(node.val < 0) {
            count[0] += Math.abs(node.val - 1);
            return node.val - 1;
        }
        return 0;
    }
}
