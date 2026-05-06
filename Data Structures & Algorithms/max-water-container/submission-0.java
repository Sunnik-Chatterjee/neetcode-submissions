class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l=0,r=heights.length-1;
        while(l<r){
            int currArea = Math.min(heights[l],heights[r]) * (r-l);
            if(heights[l]<=heights[r]) l++;
            else r--;
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }
}
