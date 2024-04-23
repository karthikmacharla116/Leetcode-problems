Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

Intiution:
  Use In-Order traversal, DFS

Solution: Optimized, without using extra space

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
class KthSmallestInTree {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k).val;
    }

    TreeNode inOrder(TreeNode node, int k) {
        if(node == null) {
            return node; 
        }

        TreeNode left = inOrder(node.left, k);
        if(left != null)
            return left;
        count++;
        if(count == k)
            return node;
        return inOrder(node.right, k);
    }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        return list.get(k-1);
    }

    void dfs(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        
        dfs(node.left, list);
        list.add(node.val);        
        dfs(node.right, list);
    }
}
