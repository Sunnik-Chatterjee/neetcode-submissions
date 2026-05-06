class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int curr = 1;
                int i = num;
                while(set.contains(num+1)){
                    curr++;
                    num++;
                }
                longest = Math.max(curr,longest);
            }
        }
        return longest;
    }
}
