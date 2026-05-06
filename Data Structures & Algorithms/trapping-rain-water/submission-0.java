class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int maxL=height[l],maxR=height[r];
        int ans = 0;
        while(l<r){
            if(maxL<=maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                ans += maxL - height[l];
            }else{
                r--;
                maxR = Math.max(maxR,height[r]);
                ans += maxR - height[r];
            }
        }
        return ans;
    }
}
