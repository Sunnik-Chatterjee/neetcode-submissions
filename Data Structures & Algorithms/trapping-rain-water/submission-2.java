class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int maxL = height[l],maxR = height[r];
        int maxArea = 0;
        while(l<=r){
            int area = 0;
            if(maxL<maxR){
                maxL = Math.max(maxL,height[l]);
                area = maxL - height[l];
                l++;
            }else{
                maxR = Math.max(maxR,height[r]);
                area = maxR - height[r];
                r--;
            }
            maxArea +=area;
        }
        return maxArea;
    }
}
