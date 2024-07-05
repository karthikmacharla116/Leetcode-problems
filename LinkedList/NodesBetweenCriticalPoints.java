Problem Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/?envType=daily-question&envId=2024-07-05

Intuition:
  LinkedList, In-Place traversal, minimum and maximum difference b/w values

Solution: Optimized
class NodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

       ListNode prev=head;
       ListNode curr=head.next;

       int first_index=-1;
       int last_index=-1;

       int index=1;
       int prev_index=-1;

       int min_dist=Integer.MAX_VALUE;
       while(curr.next!=null){
        if(prev.val>curr.val && curr.val<curr.next.val   || prev.val<curr.val && curr.val>curr.next.val){
            if(prev_index==-1){
                first_index=index;
                prev_index=index;
            }
            else{
                if(min_dist>index-prev_index){
                    min_dist=index-prev_index;
                }
                prev_index=index;
            }
        }
        index++;
        curr=curr.next;
        prev=prev.next;
       }
       last_index=prev_index;
       int max_dist=-1;

       if(min_dist==Integer.MAX_VALUE ){
         int[]arr={-1,-1};
         return arr;
       } 

       max_dist=last_index-first_index;
        int []arr={min_dist,max_dist};
        return arr
    }
}

//Brute Force: Using List<Integer>
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
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        List<Integer> indices = new ArrayList();
        findCPoints(head, head.next, 1, indices);
        System.out.println(indices);

        if(indices.size() < 2)
            return new int[]{-1,-1};
        
        int maxDiff = Math.abs(indices.get(0) - indices.get(indices.size()-1));
        int minDiff = Integer.MAX_VALUE;

        for(int i=1;i<indices.size();i++) {
            minDiff = Math.min(minDiff, indices.get(i)-indices.get(i-1));
        }
        return new int[]{minDiff, maxDiff};
    }

    void findCPoints(ListNode prev, ListNode curr, int index, List<Integer> list) {
        if(curr == null)
            return;
        
        if(curr.next != null) {
            if(prev.val < curr.val && curr.next.val < curr.val){
                list.add(index);
            } else if(prev.val > curr.val && curr.next.val > curr.val) {
                list.add(index);
            }
            prev = curr;
            curr = curr.next;
        } else {
            return;
        }
        findCPoints(prev, curr, index+1, list);
    }
}
