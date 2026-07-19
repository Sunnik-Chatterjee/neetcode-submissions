class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums);
        return res;
    }
    void backtrack(List<List<Integer>> res, List<Integer> tempList,int[] nums){
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
        }
        for(int num : nums){
            if(tempList.contains(num)) continue;
            tempList.add(num);
            backtrack(res,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }
}
