class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> resultList = new HashSet<>();
        backtrack(resultList,new ArrayList<>(),candidates,target,0,0);
        return new ArrayList<>(resultList);
    }
    public void backtrack(Set<List<Integer>> resultList, List<Integer> tempList,int[] nums,int target,int sum, int start){
        if(sum==target){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        if(sum>target) return;
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            tempList.add(nums[i]);
            sum+=nums[i];
            backtrack(resultList,tempList,nums,target,sum,i+1);
            tempList.remove(tempList.size()-1);
            sum-=nums[i];
        }
    }
}
