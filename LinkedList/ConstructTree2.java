Problem Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

Intuition:
  HashTable, DFS, Divide & conquer

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
class ConstructTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexMap = new HashMap();

        int length = postorder.length;
        // In-place reversal of array
        for(int i = 0; i < length / 2; i++) {
            // Swapping the elements
            int j = postorder[i];
            postorder[i] = postorder[length - i - 1];
            postorder[length - i - 1] = j;
        }
        
        for(int i=0;i<inorder.length;i++) 
            indexMap.put(inorder[i], i);
        
        return helper(inorder, postorder, 0, inorder.length-1, 0, indexMap);
    }

    TreeNode helper(int[]inorder, int[] postorder, int inStart, int inEnd, int postStart, Map<Integer, Integer> map) {
        if(inStart > inEnd)
            return null;
        
        TreeNode node = new TreeNode(postorder[postStart]);
        int nodeIndex = map.get(postorder[postStart]);
        int rightSubTree = inEnd - nodeIndex;

        node.right = helper(inorder, postorder, nodeIndex+1, inEnd, postStart+1, map);
        node.left = helper(inorder, postorder, inStart, nodeIndex-1, postStart+rightSubTree+1, map);
        
        return node;
    }

}
