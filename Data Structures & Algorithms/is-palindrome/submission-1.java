class Solution {
    public boolean isPalindrome(String s) {
        String validString = s.replaceAll("[^0-9a-zA-z]","").toLowerCase();
        int i=0,j=validString.length()-1;
        while(i<j){
            if(validString.charAt(i)!=validString.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
