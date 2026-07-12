class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums,0);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList,List<Integer> tempList,int[] nums,int start){
        resultList.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(resultList,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
