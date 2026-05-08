class Solution {
    public int characterReplacement(String s, int k) {
        int[] countArray = new int[26];
        int l=0,maxF=0,ans=0;
        for(int r = 0;r<s.length();r++){
            countArray[s.charAt(r)-'A']++;
            maxF = Math.max(maxF,countArray[s.charAt(r)-'A']);
            while((r-l)+1-maxF>k){
                countArray[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans,(r-l)+1);
        }
        return ans;
    }
}
