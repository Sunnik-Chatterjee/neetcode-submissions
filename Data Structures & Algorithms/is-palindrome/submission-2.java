class Solution {
    public boolean isPalindrome(String s) {
        String workingStr = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l=0,r=workingStr.length()-1;
        while(l<r){
            if(workingStr.charAt(l)!=workingStr.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
