class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        Map<Character,Integer> freq1 = new HashMap<>();
        Map<Character,Integer> freq2 = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            freq2.put(t.charAt(i),freq2.getOrDefault(t.charAt(i),0)+1);
        }
        int have = 0, need = freq2.size();
        int i=0,j=0;
        int minLen = Integer.MAX_VALUE,startIndex = 0;
        while(i<s.length()){
            freq1.put(s.charAt(i),freq1.getOrDefault(s.charAt(i),0)+1);
            if(freq2.containsKey(s.charAt(i)) && freq1.get(s.charAt(i)) == freq2.get(s.charAt(i)))have++;
            while(have==need){
                if(minLen>(i-j)+1){
                    minLen = i-j+1;
                    startIndex = j;
                }
                freq1.put(s.charAt(j),freq1.getOrDefault(s.charAt(j),0)-1);
                if(freq2.containsKey(s.charAt(j)) && freq1.get(s.charAt(j)) < freq2.get(s.charAt(j)))have--;
                j++;
            }
            i++;
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(startIndex,startIndex+minLen);
    }
}
