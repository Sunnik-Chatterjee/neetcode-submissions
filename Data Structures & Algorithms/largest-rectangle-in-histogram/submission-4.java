class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int[] top = st.pop();
                int height = top[1];
                int index = top[0];
                maxArea = Math.max(maxArea,height*(i-index));
                start = index;
            }
            st.push(new int[]{start,heights[i]});
        }
        int n=heights.length;
        for(int[] top:st){
            int height = top[1];
            int index = top[0];
            maxArea=Math.max(maxArea,height*(n-index));
        }
        return maxArea;
    }
}
