import java.util.*;
class Solution {

    // Function to check whether a queen can be placed
    public boolean isSafe(int row, int col, char[][] board, int n) {

        // Check left side of current row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    // Backtracking 
    public void solve(int col, char[][] board,
                      List<List<String>> ans, int n) {

        // Base case
        if (col == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try placing queen in every row
        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board, n)) {

                // Place Queen
                board[row][col] = 'Q';

                // Recursive call
                solve(col + 1, board, ans, n);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n]; // make the board array

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);

        return ans;
    }
}