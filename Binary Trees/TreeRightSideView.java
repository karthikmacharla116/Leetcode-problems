Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/

Intuition:
  Very similar to level order traversal

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
class TreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> list = new ArrayList();
        return bfs(queue, list);
    }
    
    List<Integer> bfs(Queue<TreeNode> queue, List<Integer> list) {
        if(queue.isEmpty())
            return list;
        
        int level = queue.size();
        for(int i=0;i<level;i++) {
            TreeNode temp = queue.poll();
            
            if(i == level-1){ //last element in the level
                list.add(temp.val);
            }
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
            
        return bfs(queue, list);
    }
}
