public class Board {
    private int n;
    private boolean[][] board;
    private int placedQueens;

    Board(int n) {
        this.n = n;
        this.board = new boolean[n][n];
        this.placedQueens = 0;
    }

    void placeQueen(int x, int y) {
        this.board[x][y] = true;
        this.placedQueens++;
    }

    void clearQueen(int x, int y) {
        this.board[x][y] = false;
        this.placedQueens--;
    }

    boolean inBoard(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    boolean isAttacked(int x, int y) {
        // check rows and columns
        for (int i = 0; i < n; i++) {
            if (this.board[x][i])
                return true;
            if (this.board[i][y])
                return true;
        }

        // check diagonals
        for (int i = 0; i < n; i++) {
            int deviation = i - x;

            if (this.inBoard(i, y - deviation) && this.board[i][y - deviation])
                return true;
            if (this.inBoard(i, y + deviation) && this.board[i][y + deviation])
                return true;
        }

        return false;
    }

    boolean solve() {
        if (this.placedQueens == this.n)
            return true;

        int currentRow = placedQueens;

        // for each cell in the current row
        for (int i = 0; i < n; i++) {
            // If the current cell is available
            if (!this.isAttacked(currentRow, i)) {
                this.placeQueen(currentRow, i);

                // Try and recursively place the remaining queens
                if (!this.solve()) {
                    this.clearQueen(currentRow, i);
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    ;

    void print() {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
        }
    }
}
