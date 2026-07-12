class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, target, 0, 0);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums,
        int target, int sum, int start) {
        if (sum == target) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        if (sum > target)
            return;
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            sum += nums[i];
            backtrack(resultList, tempList, nums, target, sum, i);
            tempList.remove(tempList.size() - 1);
            sum -= nums[i];
        }
    }
}
