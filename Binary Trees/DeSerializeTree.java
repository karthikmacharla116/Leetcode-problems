Problem Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return preorder(root, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        return helper(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    TreeNode helper(Queue<String> data) {
        if(data.isEmpty())
            return null;
        String value = data.poll();
        if(value.equals("n"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = helper(data);
        node.right = helper(data);
        return node;
    }

    private String preorder(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("n").append(",");
            return sb.toString();
        }
        sb.append(Integer.toString(node.val)).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
