Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Intuition:
  Breadth First Search, Queue, Collections.reverse()  OR 

  Use Deque(Doubly ended Queue)
	For Normal order
		- Remove from front
		-Add from back
	
	For Reverse order
		-Remove from the back/end
		-Add from Front

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
class ZigzagLevelTreeTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList();
        return bfs(queue, result, false);
    }
    
    List<List<Integer>> bfs(Queue<TreeNode> queue, List<List<Integer>> result, boolean isRight) {
        if(queue.isEmpty())
            return result;
        
        int levelSize = queue.size();
        List<Integer> list = new ArrayList();
        for(int i=0;i<levelSize;i++) {
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null)
                queue.offer(currentNode.left);
            if(currentNode.right != null)
                queue.offer(currentNode.right);
            list.add(currentNode.val);
        }
        
        if(isRight)
            Collections.reverse(list);
        result.add(list);
        return bfs(queue, result, !isRight);
    }
}






