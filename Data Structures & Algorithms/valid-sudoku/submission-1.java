class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] boxs = new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            boxs[i]=new HashSet<>();
        }

        for(int r=0;r<board.length;r++){
            for(int c =0;c<board[0].length;c++){
                int cell = board[r][c];
                if(cell == '.') continue;
                if(rows[r].contains(cell)) return false;
                rows[r].add(cell);
                if(cols[c].contains(cell)) return false;
                cols[c].add(cell);
                int boxIndex = 3*(r/3)+(c/3);
                if(boxs[boxIndex].contains(cell)) return false;
                boxs[boxIndex].add(cell);
            }
        }
        return true;
    }
}
