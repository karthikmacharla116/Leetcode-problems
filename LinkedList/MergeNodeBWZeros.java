Problem Link: https://leetcode.com/problems/merge-nodes-in-between-zeros/description/?envType=daily-question&envId=2024-07-04

Intuition:
  LinkedList, In-place Traversal

Solution:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeNodeBWZeros {
    public ListNode mergeNodes(ListNode head) {
        
        ListNode merged = new ListNode(0);

        merge(merged, head.next);

        return merged;
    }

    void merge(ListNode res, ListNode node) {
        if(node == null)
            return;
        
        if(node.val == 0 && node.next != null) {
            res.next = new ListNode(0);
            res = res.next;
        } else{
            res.val += node.val;
        }
        merge(res, node.next);
    }
}
