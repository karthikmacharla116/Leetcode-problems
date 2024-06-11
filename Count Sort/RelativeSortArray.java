Problem Link: https://leetcode.com/problems/relative-sort-array/description/?envType=daily-question&envId=2024-06-11

Solution:
class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //count sort
        int largest = -1;
        for(int num: arr1) {
            if(num > largest)
                largest = num;
        }

        //freq arr
        int[] freq = new int[largest+1];
        for(int num: arr1) {
            freq[num]++;
        }

        //arr2(specified ordered  array)
        int[] res = new int[arr1.length];
        int index = 0;
        for(int j=0;j<arr2.length;j++) {
            while(freq[arr2[j]]>0) {
                res[index++] = arr2[j];
                freq[arr2[j]]--;
            }
        }

        //There might be a chance of existing elements which are not specified in arr2
        for(int i=0;i<freq.length;i++) {
            while(freq[i] > 0) {
                res[index++] = i;
                freq[i]--;
            }
        }

        return res;
    }
}
