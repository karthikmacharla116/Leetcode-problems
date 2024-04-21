Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

Solution: Optimized, Space complexity is O(1) 
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
class FlattenTreeToList {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        TreeNode current = root;

        while(current != null) {
            if(current.left != null) {
                TreeNode temp = current.left;
                while(temp.right != null)
                    temp = temp.right;
                
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }

    }
}

Brute Force: O(N) space

class Solution {
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        dfs(queue, root);

        TreeNode list = new TreeNode();
        TreeNode temp = list;
        while(!queue.isEmpty()) {
            temp.right = queue.poll();
            temp.left = null;
            temp = temp.right;
        }
        list = list.right;
    }

    void dfs(Queue<TreeNode> queue, TreeNode node) {
        if(node == null)
            return;

        queue.add(node);
        dfs(queue, node.left);        
        dfs(queue, node.right);
    }
}
