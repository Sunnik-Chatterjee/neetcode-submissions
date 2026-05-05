class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i: nums){
            map.put(i,Boolean.FALSE);
        }
        int longest = 0;
        for(int i:nums){
            int currentLength = 1;
            int nextNum = i+1;
            while(map.containsKey(nextNum) && map.get(nextNum)==Boolean.FALSE){
                currentLength++;
                map.put(nextNum,Boolean.TRUE);
                nextNum++;
            }
            int prevNum = i-1;
            while(map.containsKey(prevNum) && map.get(prevNum)==Boolean.FALSE){
                currentLength++;
                map.put(nextNum,Boolean.TRUE);
                prevNum--;
            }
            longest = Math.max(longest,currentLength);
        }
        return longest;

    }
}
