class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st=new Stack<>();
        minSt=new Stack<>();
    }
    
    public void push(int val) {
        if(st.empty()){
            st.push(val);
            minSt.push(val);
        }else{
            if(minSt.peek()>val) minSt.push(val);
            else minSt.push(minSt.peek());
            st.push(val);
        }
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
