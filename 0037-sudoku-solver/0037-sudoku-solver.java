class Solution {

    public boolean isValid(char[][] board, int row, int col, char c) {
        // Checking columns for duplicates of c
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }

        // Checking rows for duplicates of c
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) return false;
        }

        // imp -> box finding formula of (3x3)
        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);

        // Checking 3x3 box for duplicates
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == c) return false;
            }
        }

        // No conflicts, placement is valid
        return true;
    }

    public boolean solve(char[][] board){
        // Traversing the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If board value found is empty
                if (board[i][j] == '.') {
                    // Try from 1->9
                    for (char c = '1'; c <= '9'; c++) {
                        // using helper function for checking correct c value 
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            
                            if (solve(board)) return true;

                            // Backtrack if needed
                            board[i][j] = '.';
                        }
                    }
                    // If no number fits, backtrack
                    return false;
                }
            }
        }
        // All correct
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}