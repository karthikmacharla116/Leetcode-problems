Problem Link: https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26

Intuition:
  BST, In-order traversal, self-balancing tree(rotations left rotate, right rotate)

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
class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        inOrder(root, list);

        int start = 0;
        int end = list.size()-1;
        
        return balance(list, start, end);
    }

    TreeNode balance(List<Integer> list, int start, int end) {
        if(start>end)
            return null;
        int mid = (end-start)/2 + start;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = balance(list, start, mid-1);
        node.right = balance(list, mid+1, end);
        return node;
    }


    void inOrder(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
