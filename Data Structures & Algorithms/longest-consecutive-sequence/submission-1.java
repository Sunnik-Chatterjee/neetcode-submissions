class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int i = num;
                int curr = 1;
                while(set.contains(i+1)){
                    curr++;i++;
                }
                longest = Math.max(longest,curr);
            }
        }
        return longest;
    }
}
