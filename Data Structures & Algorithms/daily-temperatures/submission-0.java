class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            if(st.isEmpty()){ 
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int indices = st.peek();
                st.pop();
                ans[indices] = i - indices;
            }
            st.push(i);
        }
        return ans;
    }
}
