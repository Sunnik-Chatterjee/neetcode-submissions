class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!st.isEmpty() && heights[i]<st.peek()[1]){
                int[] topEle = st.pop();
                int index = topEle[0],height=topEle[1];
                maxArea = Math.max(maxArea,height*(i-index));
                start = index;
            }
            st.push(new int[]{start,heights[i]});
        }
        for(int[] top : st){
            int index = top[0];
            int height = top[1];
            maxArea = Math.max(maxArea,height*(heights.length-index));
        }
        return maxArea;
    }
}
