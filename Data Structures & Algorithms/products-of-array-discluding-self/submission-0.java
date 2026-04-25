class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        ans[0]=1;
        for(int i=1;i<size;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        int suffixProduct =1;
        for(int i=size-1;i>=0;i--){
            ans[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return ans;
    }
}  
