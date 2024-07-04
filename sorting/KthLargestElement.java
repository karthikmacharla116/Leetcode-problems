Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Intuition:
  Partial Sorting, Heap Sort(Priority Queue)

Solution:
class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        
        //partial sorting
        PriorityQueue<Integer> maxHeap = new PriorityQueue();

        for(int num : nums) {
            maxHeap.add(num);
            if(maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        return maxHeap.peek();
    }
}
