Problem Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

Intuition:
  BFS, HashTable

Solution
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
class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        Set<Integer> set = new HashSet();

        return bfs(queue, set, k);
    }

    boolean bfs(Queue<TreeNode> queue, Set<Integer> set, int k) {
        if(queue.isEmpty())
            return false;
        
        int level = queue.size();
        int i=0;
        while(i<level) {
            
            TreeNode node = queue.poll();
            if(!set.isEmpty() && set.contains(k-node.val)) {
                return true;
            } else {
                set.add(node.val);
            }
            i++;

            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return bfs(queue, set, k);
    }
}
