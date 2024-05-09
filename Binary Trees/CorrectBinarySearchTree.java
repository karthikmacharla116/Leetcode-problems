Problem Link: Correct Binary Tree That Has Two Nodes Swapped - FAANG Interview Question

Intuition:
  DFS, In-order traversal, comparing the nodes with already visited node(previous)

Solution:
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class CorrectBinarySearchTree {

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void correctBST(TreeNode root) {
    
        iot(root);
    }

    public void iot(TreeNode node) {
        if(node == null)
            return;

        iot(node.left);

        if(prev != null && prev.val > node.val) {
            if(first == null)
                first = prev;
            second = node;
        } 
        prev = node;
        iot(node.right);
    }

}
