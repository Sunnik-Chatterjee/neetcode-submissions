class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> check = new HashMap<>();
        for(int num : nums){
            check.put(num,Boolean.FALSE);
        }
        int longest = 0;
        for (int num : nums){
            int curr = 1;
            int nextNum = num + 1;
            while(check.containsKey(nextNum) && !check.get(nextNum)){
                curr++;
                nextNum++;
            }
            int prevNum = num - 1;
            while(check.containsKey(prevNum) && !check.get(prevNum)){
                curr++;
                prevNum--;
            } 
            longest = Math.max(longest,curr);
        } 
        return longest;
    }
}
