Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Intuition:
  BFS, Queue

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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        List<List<Integer>> list = new ArrayList();
        return bfs(queue, list);
    }

    List<List<Integer>> bfs(Queue<TreeNode> queue, List<List<Integer>> list) {
        if(queue.isEmpty())
            return list;
        
        List<Integer> aList = new ArrayList();
        int levelSize = queue.size();
        for(int i=0;i<levelSize;i++) {
            TreeNode temp = queue.poll();
            aList.add(temp.val);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        list.add(aList);
        return bfs(queue, list);
    }
}
