class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res,new ArrayList<String>(),s);
        return res;
    }
    void backtrack(List<List<String>> res, List<String> tempList,String s){
        if(s.length()==0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<s.length();i++){
            String val = s.substring(0,i+1);
            if(isPalindrome(val)){
                tempList.add(val);
                backtrack(res,tempList,s.substring(i+1));
                tempList.remove(tempList.size()-1);
            }
        }
    }
    boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
