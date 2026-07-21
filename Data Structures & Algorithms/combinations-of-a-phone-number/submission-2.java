class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res,sb,digits,0);
        return res;
    }
    private final static String[] numsPad = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
    void backtrack(List<String> res, StringBuilder sb, String digits,int index){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index)-'0';
        for(int i=0;i<numsPad[digit-2].length();i++){
            sb.append(numsPad[digit-2].charAt(i));
            backtrack(res,sb,digits,index+1);
            sb.setLength(sb.length()-1);
        }
    }
}
