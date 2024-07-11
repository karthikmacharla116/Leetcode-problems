Problem Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/?envType=daily-question&envId=2024-07-11

//Optimized
class ReverseParentheses {
    public String reverseParentheses(String s) {
        StringBuilder builder = new StringBuilder(s);

        Stack<Integer> stack = new Stack(); //indexes

        for(int i=0;i<s.length();i++) {
            if(builder.charAt(i) == '(') {
                stack.add(i);
            } else if(builder.charAt(i) == ')') {
                int start = stack.pop();
                String subStr = new StringBuilder(builder.substring(start+1, i)).reverse().toString();
                builder.replace(start+1, i, subStr);
            }
        }
        String reversed = builder.toString();
        System.out.println(reversed);
        reversed = reversed.replaceAll("[(]", "");
        reversed = reversed.replaceAll("[)]", "");

        return reversed;
    }
}


class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) != ')') {
                stack.add(s.charAt(i));
            } else {
                String subStr = "";
                while(!stack.isEmpty()) {
                    char c = stack.pop();
                    if(c != '(') {
                        subStr = subStr + c;
                    } else {
                        break;
                    }
                }
                int index = 0;
                while(index<subStr.length()) {
                    stack.add(subStr.charAt(index));
                    index++;
                }   
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(stack);
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
