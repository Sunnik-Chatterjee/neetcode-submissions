class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) return false;
        Map<Character,Integer> mpp = new HashMap<>();
        for(int i=0;i<n1;i++){
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<n2;i++){
            if(!mpp.containsKey(t.charAt(i))) return false;
            mpp.put(t.charAt(i),mpp.getOrDefault(t.charAt(i),0)-1);
            if(mpp.get(t.charAt(i))<0) return false;
        }
        return true;
    }
}
