Problem Link: https://leetcode.com/problems/crawler-log-folder/description/?envType=daily-question&envId=2024-07-10

Solution: Optimized 
class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        
        int depth = 0;

        for(String path : logs) {

            if(path.equals("../")) {
                depth = Math.max(0, depth-1);
            } else if(!path.equals("./")) {
                depth++;;
            }
        }

        return depth;
    }
}

//Using Stack
class Solution {
    public int minOperations(String[] logs) {
        
        Stack<String> stack = new Stack();

        for(String path : logs) {

            if(path.equals("../")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else if(!path.equals("./")) {
                stack.add(path);
            }
        }

        return stack.size();
    }
}
