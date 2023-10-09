public class nqueens {

    public void printSolution(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isSafe(int row, int col, char[][] board, int n) {
        int i = row;
        int j = col;

        while (j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            j--;
        }

        i = row;
        j = col;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void solve(char[][] board, int col, int n) {
        if (col >= n) {
            printSolution(board, n);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }
    public static void main(String[] args) {
        int n = 7;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int col = 0;

        nqueens nq = new nqueens();
        nq.solve(board, col++, n);




    }
}
