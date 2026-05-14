class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for(int i =0;i<nums.length-2;i++){
            if(nums[i]>0) continue;
            int l =i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else if(sum>0) r--;
                else l++;
            }
        }
        return new ArrayList<>(ans);
    }
}
