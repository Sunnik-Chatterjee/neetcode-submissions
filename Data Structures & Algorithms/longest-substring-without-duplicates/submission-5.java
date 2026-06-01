class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int maxLen = 1;
        int j=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(!set.isEmpty() && set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            maxLen = Math.max(i-j+1,maxLen);
        }
        return maxLen;
    }
}
