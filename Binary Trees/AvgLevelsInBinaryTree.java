Problem Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/

Intuition:
  Queue, BFS

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
class AvgLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> list = new ArrayList();
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        return bfs(queue, list);
    }
    
    List<Double> bfs(Queue<TreeNode> queue, List<Double> list) {
        if(queue.isEmpty()) {
            return list;
        }
        
        Double avg = 0.0;
        int levelSize = queue.size();
        
        for(int i=0;i<levelSize;i++) {
            TreeNode temp = queue.poll();
            avg += temp.val;
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        avg /= levelSize;
        list.add(avg);
        return bfs(queue, list);
    }

}

