class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'))
                return false;
            else if (st.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                st.push(s.charAt(i));
            else {
                if (st.peek() == '(' && s.charAt(i) == ')' || st.peek() == '[' && s.charAt(i) == ']'
                    || st.peek() == '{' && s.charAt(i) == '}')
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
