class Solution {
    public boolean isPalindrome(String s) {
        String work = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = work.length();
        for(int i=0;i<n;i++){
            if(work.charAt(i)!=work.charAt(n-1-i)) return false;
        }
        return true;
    }
}
