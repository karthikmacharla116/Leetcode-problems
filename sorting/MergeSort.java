Problem Link: https://leetcode.com/problems/sort-an-array/description/?envType=daily-question&envId=2024-07-25

Intuition:
  Merge Sort O(nlogn)

Solution:
  class MergeSort {
    public int[] sortArray(int[] nums) {

        //merge sort
        mergeSort(nums, 0, nums.length);
        return nums;
    }
    void mergeSort(int[] nums, int start, int end) {
        if(end - start == 1)
            return;
        
        int mid = start + (end-start)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);

        merge(nums, start, mid, end);
    }

    void merge(int[] nums, int start, int mid, int end) {

        int i = start;
        int j = mid;
        int k = 0;

        int[] mixed = new int[end-start];
        while(i < mid && j < end) {
            if(nums[i] < nums[j]) {
                mixed[k] = nums[i];
                i++;
            } else {
                mixed[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i < mid) {
            mixed[k] = nums[i];
            i++;
            k++;
        }
        while(j < end) {
            mixed[k] = nums[j];
            j++;
            k++;
        }

        //updating the existing array
        for(int l=0;l<mixed.length;l++) {
            nums[start+l] = mixed[l];
        }
    }
}
