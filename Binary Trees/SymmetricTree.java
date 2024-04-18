Problem Link: https://leetcode.com/problems/symmetric-tree/

Intuition:
  Build the thought process, draw the tree.

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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root.left);
        queue.offer(root.right);
        return bfs(queue);
    }
    
    boolean bfs(Queue<TreeNode> queue) {
        if(queue.isEmpty()) {
            return true;
        }
        
        int level = queue.size();
        
        for(int i=0;i<level;i+=2) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            
            if(node1 == null && node2 == null)
                continue;
            if(node1 == null || node2 == null)
                return false;
            
            if(node1.val != node2.val)
                return false;
            
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return bfs(queue);
    }
    
}

