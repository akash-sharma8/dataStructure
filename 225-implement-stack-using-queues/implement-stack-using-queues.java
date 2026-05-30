class MyStack {
    private Queue<Integer> first;
    

    public MyStack() {
        first = new LinkedList<>();
    
    }
    
    public void push(int x) {
        first.add(x);
        for(int i =0; i<first.size()-1; i++){
            first.add(first.poll());
        }
    }
    
    public int pop() {
        return first.poll();
    }
    
    public int top() {
        return first.peek();
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */