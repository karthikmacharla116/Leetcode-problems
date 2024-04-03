Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/description/

Solution:

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack();
        this.outStack = new Stack();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
