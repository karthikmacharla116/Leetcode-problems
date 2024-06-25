Problem Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/?envType=daily-question&envId=2024-06-25
  https://leetcode.com/problems/convert-bst-to-greater-tree/description/

Intuition:
  DFS, In-order traversal, BST

Solution: Optimized
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
class BstToGst {
    public TreeNode bstToGst(TreeNode root) {

        int[] grs = new int[1];
        inOrder(root, grs);
        return root;
    }

    void inOrder(TreeNode node, int[] grs) {
        if(node == null)
            return;
        
        inOrder(node.right, grs);
        grs[0] += node.val;
        node.val = grs[0];
        inOrder(node.left, grs);
    }
}

//Brute Force
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
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();

        inOrder(root, list);

        int sum = 0;
        for(int i= list.size()-1;i>=0;i--) {
            list.set(i,list.get(i) + sum);
            sum = list.get(i);
        }
        System.out.println(list);
        
        inOrder2(root, list);
        
        return root;
    }

    void inOrder2(TreeNode node, LinkedList<Integer> list) {
        if(node == null)
            return;
        
        inOrder2(node.left, list);
        node.val = list.poll();
        inOrder2(node.right, list);
    }

    void inOrder(TreeNode node, LinkedList<Integer> list) {
        if(node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
