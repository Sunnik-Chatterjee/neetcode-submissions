class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        Map<Character,Integer> count1 = new HashMap<>();
        Map<Character,Integer> count2 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            count1.put(s1.charAt(i),count1.getOrDefault(s1.charAt(i),0)+1);
        }
        int l = 0;
        for(int r = 0;r<s2.length();r++){
            count2.put(s2.charAt(r),count2.getOrDefault(s2.charAt(r),0)+1);
            while((r-l)+1 > s1.length()){
                count2.put(s2.charAt(l),count2.getOrDefault(s2.charAt(l),0)-1);
                if(count2.get(s2.charAt(l))==0) count2.remove(s2.charAt(l));
                l++;
            }
            if(count1.equals(count2)) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
