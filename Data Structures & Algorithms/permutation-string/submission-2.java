class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        int matches = 0;
        for(int i =0;i<26;i++){
            if(count1[i]==count2[i]) matches++;
        }
        int j = 0;
        for(int i=s1.length();i<s2.length();i++){
            if(matches==26) return true;
            
            count2[s2.charAt(i)-'a']++;
            
            if(count1[s2.charAt(i)-'a']==count2[s2.charAt(i)-'a']) matches++;
            else if(count1[s2.charAt(i)-'a']+1==count2[s2.charAt(i)-'a']) matches--;
            
            count2[s2.charAt(j)-'a']--;
            
            if(count1[s2.charAt(j)-'a']==count2[s2.charAt(j)-'a']) matches++;
            else if(count1[s2.charAt(j)-'a']-1==count2[s2.charAt(j)-'a']) matches--;
            j++;
        }
        return 26==matches;
    }
}
