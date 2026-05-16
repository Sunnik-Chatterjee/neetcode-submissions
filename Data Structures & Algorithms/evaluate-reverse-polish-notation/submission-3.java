class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (s.matches("-?\\d+"))
                st.push(Integer.parseInt(s));
            else {
                int num1, num2;
                switch (s) {
                    case "+":
                        num2 = st.peek();
                        st.pop();
                        num1 = st.peek();
                        st.pop();
                        st.push(num1 + num2);
                        break;
                    case "-":
                        num2 = st.peek();
                        st.pop();
                        num1 = st.peek();
                        st.pop();
                        st.push(num1 - num2);
                        break;
                    case "*":
                        num2 = st.peek();
                        st.pop();
                        num1 = st.peek();
                        st.pop();
                        st.push(num1 * num2);
                        break;
                    case "/":
                        num2 = st.peek();
                        st.pop();
                        if (num2 != 0) {
                            num1 = st.peek();
                            st.pop();
                            st.push(num1 / num2);
                        }
                }
            }
        }
       return st.peek();
    }
}
