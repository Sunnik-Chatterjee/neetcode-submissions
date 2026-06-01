class Solution {
    public int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            if(!set.contains(i-1)){
                int count = 1;
                while(set.contains(i+1)){
                    count++;
                    i++;
                }
                maxSeq = Math.max(maxSeq,count);
            }
        }
        return maxSeq;
    }
}
