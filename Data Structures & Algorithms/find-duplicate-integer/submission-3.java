class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        while(fast<nums.length){
            fast=nums[nums[fast]];
            slow = nums[slow];
            if(fast==slow) break;
        }
        int slow2=0;
        while(slow2!=slow){
            slow2=nums[slow2];
            slow=nums[slow];
        }
        return slow;
    }
}
