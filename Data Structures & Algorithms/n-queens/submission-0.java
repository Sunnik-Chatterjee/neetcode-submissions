class Solution {
    void saveBoard(char[][] board,List<List<String>> ans){
        String row = "";
        List<String> currBoard = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            row = "";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='Q') row+='Q';
                else row+=".";
            }
            currBoard.add(row);
        }
        ans.add(currBoard);
    }
    boolean isSafe(char[][] board,int row,int col){
        //Diagonal
        for(int j = 0;j<board[0].length;j++){
            if(board[row][j]=='Q') return false;
        }
        //Vertical
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q') return false;
        }
        //left upper
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        //right upper
        for(int i=row,j=col;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        //left lower
        for(int i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j]=='Q') return false;
        }
        //right lower
        for(int i=row,j=col;i<board.length && j<board[0].length;i++,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        backtrack(ans,board,n,0);
        return ans;
    }
    void backtrack(List<List<String>> ans, char[][] board,int n,int col){
        if(col==board.length){
            saveBoard(board,ans);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                backtrack(ans,board,n,col+1);
                board[row][col]='.';
            }
        }
    }
}
