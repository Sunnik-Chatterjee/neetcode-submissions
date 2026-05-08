class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char para = s.charAt(i);
            if (para == '(' || para == '[' || para == '{')
                st.push(para);
            else {
                if(st.empty()) return false;
                if ((para == ')' && st.peek() != '(') || (para == ']' && st.peek() != '[')
                    || (para == '}' && st.peek() != '{'))
                    return false;
                else
                    st.pop();
            }
        }
        return st.isEmpty();
    }
}
