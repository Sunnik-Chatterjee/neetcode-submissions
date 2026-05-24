class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int j=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(i)-'A']);
            while((i-j+1)-maxFreq>k){
                freq[s.charAt(j)-'A']--;
                j++;
            }
            maxLen = Math.max(maxLen,i-j+1);
        }
        return maxLen;
    }
}
