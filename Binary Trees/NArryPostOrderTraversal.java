Problem Link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-26

Intuition:
  DFS, Stack, Post order traversal

Solution:
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class NArryPostOrderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        // If the root is null, return the empty list
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        // Traverse the tree using the stack
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            result.add(currentNode.val);
            // Push all the children of the current node to the stack
            for (Node child : currentNode.children) stack.add(child);
        }

        // Reverse the result list to get the correct postorder traversal
        Collections.reverse(result);
        return result;
    }
}
