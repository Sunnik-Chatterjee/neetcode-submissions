class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            int len = i-j+1;
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}
