Problem Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Intuition:
  Assume LinkedList at each level of tree, try solve using constant space(exclude recursion call stack)

Solution:
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class NextRightPointerInEachNode {
    public Node connect(Node root) {
        bfsWithoutQueue(root);
        return root;
    }
    
    void bfsWithoutQueue(Node node) {
        if(node == null)
            return;
        
        Node leftMost = node;
        while(leftMost != null && leftMost.left != null && leftMost.right != null) {
            leftMost.left.next = leftMost.right;
            if(leftMost.next != null)
                leftMost.right.next = leftMost.next.left;
            leftMost = leftMost.next;
        }
        
        bfsWithoutQueue(node.left);
    }
}






