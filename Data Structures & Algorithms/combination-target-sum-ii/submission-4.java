class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }
    void backtrack(List<List<Integer>> res, List<Integer> tempList,int[] nums, int target, int sum, int start){
        if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            tempList.add(nums[i]);
            sum+=nums[i];
            backtrack(res,tempList,nums,target,sum,i+1);
            tempList.remove(tempList.size()-1);
            sum-=nums[i];
        }
    }
}
