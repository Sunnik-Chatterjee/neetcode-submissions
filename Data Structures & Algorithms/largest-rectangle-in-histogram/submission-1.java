class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i<heights.length;i++){
            int start = i;
            while(!st.isEmpty() && heights[i]<st.peek()[0]){
                int[] top = st.pop();
                int index = top[1];
                int height = top[0];
                maxArea = Math.max(maxArea, (i-index)*height);
                start = index;
            }
            st.push(new int[]{heights[i],start});
        }
        for(int[] pair : st){
            int index = pair[1];
            int height =  pair[0];
            maxArea = Math.max(maxArea, height*(heights.length-index));
        }
        return maxArea;
    }

}
