Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Intuition:
  Binary Search Tree insertion, balanced Binary Tree balanced

Solution: Optimized (but same TIme complexity)
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
class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length-1);
    }

    TreeNode bst(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums, start, mid-1);
        node.right = bst(nums, mid+1, end);

        return node;
    }
}

//Brute force
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = null;
        for(int n: nums)
            node = bst(n, node);
        return node;
    }

    TreeNode bst(int value, TreeNode node) {
        if(node == null) {
            node = new TreeNode(value);
            return node;
        }
        if(value < node.val)
            node.left = bst(value, node.left);
        else 
            node.right = bst(value, node.right);
        return rotate(node);
    }

	private TreeNode rotate(TreeNode node) {
		if(height(node.left) - height(node.right) > 1) {
			//left heavy
			if(height(node.left.left) - height(node.left.right) > 0) {
				//left left
				return rotateRight(node);
			} else if(height(node.left.left) - height(node.left.right) < 0){
				//left right
				node.left = rotateLeft(node.left); //child
				return rotateRight(node);
			}
		}

		if(height(node.left) - height(node.right) < -1) {
			//right heavy
			if(height(node.right.left) - height(node.right.right) < 0) {
				//right right
				return rotateLeft(node);
			} else if(height(node.right.left) - height(node.right.right) > 0){
				//right left
				node.right = rotateRight(node.right); //on child
				return rotateLeft(node);
			}
		}	
		return node;
	}

	private TreeNode rotateRight(TreeNode p) {
		TreeNode c = p.left;
		TreeNode t = c.right;
		
		c.right = p;
		p.left = t;
		return c;
	}
	
	private TreeNode rotateLeft(TreeNode p) {
		TreeNode c = p.right;
		TreeNode t = c.left;
		
		c.left = p;
		p.right = t;

		return c;
	}

    int height(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(height(node.left), height(node.right))+1;
    }
}
