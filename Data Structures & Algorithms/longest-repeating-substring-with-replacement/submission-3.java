class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for(int r = 0;r<s.length();r++){
            freqMap.put(s.charAt(r),freqMap.getOrDefault(s.charAt(r),0)+1);
            maxFreq = Math.max(maxFreq,freqMap.get(s.charAt(r)));
            while((r-l)+1-maxFreq>k){
                freqMap.put(s.charAt(l),freqMap.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            if(r-l+1>maxLen) maxLen = r-l+1;
        }
        return maxLen;

    }
}
