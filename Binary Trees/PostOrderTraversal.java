Problem Link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-25

Intuition:
  DFS, Post order traversal

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
class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        postOrder(root, list);
        return list;
    }


    void postOrder(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}
