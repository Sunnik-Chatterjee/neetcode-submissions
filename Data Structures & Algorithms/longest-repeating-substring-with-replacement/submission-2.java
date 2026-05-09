class Solution {
    public int characterReplacement(String s, int k) {
        int[] count1 = new int[26];
        int maxF = 0,l=0,maxLen = 0;
        for(int r =0;r<s.length();r++){
            count1[s.charAt(r)-'A']++;
            maxF = Math.max(maxF,count1[s.charAt(r)-'A']);
            while((r-l)+1-maxF>k){
                count1[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,(r-l)+1);
        }
        return maxLen;
    }
}
