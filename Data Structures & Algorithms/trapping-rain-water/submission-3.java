class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int l = 0, r=height.length-1;
        int area = 0;
        while(l<=r){
            if(leftMax<rightMax){
                leftMax=Math.max(height[l],leftMax);
                area += leftMax-height[l];
                l++;
            }else{
                rightMax = Math.max(height[r],rightMax);
                area+=rightMax-height[r];
                r--;
            }
        }
        return area;
    }
}
