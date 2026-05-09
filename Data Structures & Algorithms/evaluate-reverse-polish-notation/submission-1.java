class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int total = 0;
        for (String s : tokens) {
            if (s.matches("-?\\d+")) {
                st.push(Integer.parseInt(s));
            } else {
                int num2 = st.peek();
                st.pop();
                int num1 = st.peek();
                st.pop();
                switch (s) {
                    case "+":
                        total = num1 + num2;
                        break;
                    case "-":
                        total = num1 - num2;
                        break;
                    case "*":
                        total = num1 * num2;
                        break;
                    case "/":
                        if(num2!=0){
                            total = num1 / num2;
                        }
                }
                st.push(total);
            }
        }
        return st.peek();
    }
}
