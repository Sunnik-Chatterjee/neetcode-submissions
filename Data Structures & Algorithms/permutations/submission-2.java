class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, new ArrayList<>(),nums,visited);
        return res;
    }
    void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] visited){
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            tempList.add(nums[i]);
            backtrack(res,tempList,nums,visited);
            tempList.remove(tempList.size()-1);
            visited[i]=false;
        }

    }
}
