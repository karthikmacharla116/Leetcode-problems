Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

Intuition:
  Binary Search, duplicate elements, trim down the search space(by start+1, end-1)

Solution:
class RotatedSortedArrayII {
    public boolean search(int[] arr, int target) {
        int start = 0;
    int end = arr.length-1;
    
    int mid;
    while(start <= end) {
        mid = (end-start)/2 + start;
        if(arr[mid] == target)
            return true;//found
        else if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start += 1;
            end -= 1;
        }
        else if(arr[start] <= arr[mid]) { //check for the sub sorted array 
            //left portion is sorted
            if(arr[start] <= target && target < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        } else {
            // right portion is SORTED
            if(arr[mid] < target && target <= arr[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
    return false; //NOT FOUND    
    }
}
