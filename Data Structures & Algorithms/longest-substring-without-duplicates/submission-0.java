class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0,currLen=0;
        int i=0,j=0;
        Set<Character> window = new HashSet<>();
        while(j<s.length() && i<s.length()){
            if(!window.contains(s.charAt(i))){
                window.add(s.charAt(i));
                i++;
                currLen++;
            }else{
                window.remove(s.charAt(j));
                j++;
                currLen--;
            }
            longestLength = Math.max(longestLength,currLen);
        }
        return longestLength;  
    }
}
