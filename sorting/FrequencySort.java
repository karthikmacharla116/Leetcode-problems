Problem Link: https://leetcode.com/problems/sort-array-by-increasing-frequency/description/?envType=daily-question&envId=2024-07-23

Intuition:
  Asked in Wissen Tech(Client: Goldman Sachs), HashTable, Sorting, Custom Comparator

Solution:
class FrequencySort {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap();
        for(int num: nums) 
            freq.put(num, freq.getOrDefault(num, 0)+1);

        Integer[] numsObj = new Integer[n];
        for(int i=0;i<n;i++)
            numsObj[i] = nums[i];
        
        Arrays.sort(numsObj, (n1, n2) -> {
            if(freq.get(n1).equals(freq.get(n2))) 
                return Integer.compare(n2, n1);
            return Integer.compare(freq.get(n1), freq.get(n2));
        });

        int[] res = new int[n];
        for(int i=0;i<n;i++)
            res[i] = numsObj[i];
        return res;
    }
}
