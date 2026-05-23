class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int minLen = Integer.MAX_VALUE;
        Map<Character,Integer> freq1 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            freq1.put(t.charAt(i),freq1.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> freq2 = new HashMap<>();
        int j=0;
        int have = 0, need=freq1.size();
        int startIndex = 0;
        for(int i=0;i<s.length();i++){
            freq2.put(s.charAt(i),freq2.getOrDefault(s.charAt(i),0)+1);
            if(freq1.containsKey(s.charAt(i)) && freq2.get(s.charAt(i))==freq1.get(s.charAt(i))) have++;
            while(have==need){
                if(minLen>i-j+1){
                    minLen = i-j+1;
                    startIndex = j;
                }
                freq2.put(s.charAt(j),freq2.getOrDefault(s.charAt(j),0)-1);
                if(freq1.containsKey(s.charAt(j)) && freq2.get(s.charAt(j))<freq1.get(s.charAt(j))) have--;
                j++;
            }
        }
        if(minLen==Integer.MAX_VALUE) return "";
        return s.substring(startIndex,startIndex+minLen);
    }
}
