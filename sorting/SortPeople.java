Problem Link: https://leetcode.com/problems/sort-the-people/description/?envType=daily-question&envId=2024-07-22

Intuition:
  HashTable, Sorting

Solution:
class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Map<Integer, String> map = new HashMap();

        for(int i=0;i<n;i++) 
            map.put(heights[i], names[i]);
        
        // sorting
        Arrays.sort(heights);

        //arrange the names with their heights accordingly
        String[] people = new String[n];
        for(int i=n-1;i>=0;i--) {
            people[n-i-1] = map.get(heights[i]);
        }
        return people;
    }
}

//Brute force: Bubble sort O(n^2)
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        //bubble sort
        for(int i=0;i<n;i++) {
            for(int j=1;j<n;j++) {
                if(heights[j-1] < heights[j]) {
                    //swap
                    int swap = heights[j-1];
                    heights[j-1] = heights[j];
                    heights[j] = swap;

                    //swap the names
                    String temp = names[j-1];
                    names[j-1] = names[j];
                    names[j] = temp;
                }
            }
        }
        return names;
    }
}

