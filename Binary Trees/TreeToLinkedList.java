Problem Link: Convert Binary Tree to Doubly Linked List - FAANG Interview Question

Intuition:
  DFS, In-order traversal

Solution:
class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class TreeToLinkedList {

    ListNode head;
    ListNode tail;

    public ListNode bstToDLL(TreeNode root) {
    
        inOrder(root);
        return head;
    }

    public void inOrder(TreeNode node) {
        if(node == null)
            return;

        inOrder(node.left);

        ListNode temp = new ListNode(node.val);
        if(head != null) {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        } else {
            head = temp;
            tail = head;
        }
        inOrder(node.right);
    
    }

}
