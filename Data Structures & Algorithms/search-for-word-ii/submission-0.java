class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        HashSet<String> res = new HashSet<>();
        for(String word : words){
            addWord(word);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(doesExist(curr,board[i][j])){
                    backtrack(curr,res,sb,board,i,j);
                }
            }
        }
        return new ArrayList<>(res);
    }
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    void backtrack(TrieNode node,HashSet<String> res,StringBuilder sb,char[][]board,int row, int col){
        if(row<0||row>=board.length||col<0 || col>=board[0].length || board[row][col]=='*' || node.children[board[row][col]-'a']==null) return;
        node = node.children[board[row][col]-'a'];
        sb.append(board[row][col]);
        if(node.isEnd){
            res.add(sb.toString());
        }
        char temp = board[row][col];
        board[row][col]='*';
        for(int[] direction : directions){
            int new_i = row + direction[0];
            int new_j = col + direction[1];
            backtrack(node,res,sb,board,new_i,new_j);
        }
        sb.setLength(sb.length()-1);
        board[row][col]=temp;
    }
    void addWord(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    boolean doesExist(TrieNode node, char c){
        if(node.children[c-'a']==null) return false;
        return true;
    }
    
}
