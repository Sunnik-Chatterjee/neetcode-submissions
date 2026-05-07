class Solution {
    public int trap(int[] height) {
        int left = 0, right=height.length-1;
        int ans = 0;
        int maxL=height[left],maxR=height[right];
        while(left<=right){
            if(maxL<=maxR){
                maxL = Math.max(maxL,height[left]);
                ans += maxL - height[left]; 
                left++;
            }else{
                maxR = Math.max(maxR, height[right]);
                ans+=maxR - height[right];
                right--;
            }
        }
        return ans;
    }
}
