class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(index) && search(board,word,i,j,index)){
                    return true;
                }
            }
        }
        return false;
    }
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean search(char[][] board,String word, int i, int j, int index){
        if(index==word.length()) return true;
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]=='#'){
            return false;
        }
        if(board[i][j]!=word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j]='#';
        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(search(board,word,new_i,new_j,index+1)) {
                board[i][j]=temp;
                return true;
            }
        }
        board[i][j]=temp;
        return false;
    }
}
