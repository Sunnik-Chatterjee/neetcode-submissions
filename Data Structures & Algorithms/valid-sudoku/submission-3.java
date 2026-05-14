class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char item = board[r][c];
                if (item == '.')
                    continue;
                if (rows[r].contains(item))
                    return false;
                rows[r].add(item);
                if (cols[c].contains(item))
                    return false;
                cols[c].add(item);
                int boxIndex = 3 * (r / 3) + (c / 3);
                if (boxes[boxIndex].contains(item))
                    return false;
                boxes[boxIndex].add(item);
            }
        }
        return true;
    }
}
