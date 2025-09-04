class Solution {
    public boolean isValidSudoku(char[][] board) {
         HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];

                if (ch == '.') continue; // skip empty cells

                // Box index calculation
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If digit already exists in row/col/box → invalid
                if (rows[r].contains(ch) || cols[c].contains(ch) || boxes[boxIndex].contains(ch)) {
                    return false;
                }

                // Otherwise add digit to respective sets
                rows[r].add(ch);
                cols[c].add(ch);
                boxes[boxIndex].add(ch);
            }
        }
        return true;
    }
}
