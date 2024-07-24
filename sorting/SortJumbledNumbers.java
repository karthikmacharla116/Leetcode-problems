Problem Link: https://leetcode.com/problems/sort-the-jumbled-numbers/description/?envType=daily-question&envId=2024-07-24

Intuition:
  Mapping the sort numbers to index, Sorting, O(N)

Solution:
class SortJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;

        List<int[]> mapArr = new ArrayList();

        for(int i=0;i<n;i++) {
            //convert to string
            String number = String.valueOf(nums[i]);
            int index = 0;
            int mappedValue = 0;
            while(index < number.length()) {
                int temp = mapping[number.charAt(index)-'0'];
                mappedValue = mappedValue*10 + (temp);
                index++;
            }
            mapArr.add(new int[] {mappedValue, i});
        }

        Collections.sort(mapArr, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        //
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            res[i] = nums[mapArr.get(i)[1]];
        }


        return res;
    }
}
