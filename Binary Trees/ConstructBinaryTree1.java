Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Intuition:
  Divide & Conquer, HashTable, Binary Tree

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
class ConstructBinaryTree1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) 
            return null;
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, indexMap);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart > preEnd || inStart > inEnd) 
            return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = indexMap.get(rootVal);
        int leftSubtreeSize = rootIndex - inStart;
        
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSubtreeSize, inStart, rootIndex - 1, indexMap);
        root.right = buildTree(preorder, inorder, preStart + leftSubtreeSize + 1, preEnd, rootIndex + 1, inEnd, indexMap);
        
        return root;
    }
}

Brute force:

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) 
            return null;
        
        int r = preorder[0];

        int index = 0;
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == r)
                index = i;
        }
        TreeNode node = new TreeNode(r);
        
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));
        return node;
    }
}
