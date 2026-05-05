class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int len = s.length();
            sb.append(len).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int delimiter = str.indexOf("#",i);
            int len = Integer.parseInt(str.substring(i,delimiter));
            i = delimiter+1;
            String s = str.substring(i,i+len);
            ans.add(s);
            i+=len;
        }
        return ans;
    }
}
