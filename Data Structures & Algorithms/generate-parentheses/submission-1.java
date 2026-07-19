class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res,sb,n,0,0);
        return res;
    }
    void backtrack(List<String> res, StringBuilder sb,int n, int open,int close){
        if(sb.length()==2*n) {
            res.add(new String(sb.toString()));
            return;
        }
        if(open<n){
            sb.append("(");
            backtrack(res,sb,n,open+1,close);
            sb.setLength(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backtrack(res,sb,n,open,close+1);
            sb.setLength(sb.length()-1);
        }
    }
}
