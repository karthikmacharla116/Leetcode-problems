Problem Link: https://leetcode.com/problems/delete-nodes-and-return-forest/description/?envType=daily-question&envId=2024-07-17

Intuition:
  Using HashSet for O(1), DFS

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
class DeleteNodesReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int del : to_delete) {
            toDeleteSet.add(del);
        }
        
        List<TreeNode> forest = new ArrayList<>();
        dfs(root, toDeleteSet, forest, true);
        return forest;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest, boolean isRoot) {
        if (node == null) {
            return null;
        }
        
        boolean toBeDeleted = toDeleteSet.contains(node.val);
        
        if (isRoot && !toBeDeleted) {
            forest.add(node);
        }
        
        node.left = dfs(node.left, toDeleteSet, forest, toBeDeleted);
        node.right = dfs(node.right, toDeleteSet, forest, toBeDeleted);
        
        return toBeDeleted ? null : node;
    }
}
