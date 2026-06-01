class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int maxArea = 0;
        while(l<r){
            int area;
            if(heights[l]<heights[r]){
                area = heights[l]*(r-l);
                l++;    
            }else{
                area = heights[r]*(r-l);
                r--;
            }
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
