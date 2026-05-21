class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!st.isEmpty() && heights[i]<st.peek()[1]){
                int[] top = st.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea,(height*(i-index)));
                start = index;
            }
            st.push(new int[]{start,heights[i]});
        }
        for(int[] arr:st){
            int index = arr[0];
            int height = arr[1];
            maxArea=Math.max(maxArea,height*(heights.length-index));
        }
        return maxArea;
    }
}
