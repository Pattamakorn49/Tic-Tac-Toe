public class GameState {
    private char[] board = new char[9];
    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public GameState() {
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
        currentPlayer = 'X';
        gameOver = false;
    }

    public char[] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean makeMove(int index) {
        if (index < 0 || index >= 9) return false;
        if (board[index] != ' ') return false;
        if (gameOver) return false;

        board[index] = currentPlayer;

        if (checkWinner() != ' ' || isFull()) {
            gameOver = true;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    public char checkWinner() {
        int[][] lines = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // แนวนอน
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // แนวตั้ง
            {0, 4, 8}, {2, 4, 6}             // แนวทแยง
        };
        for (int[] line : lines) {
            char a = board[line[0]];
            char b = board[line[1]];
            char c = board[line[2]];
            if (a != ' ' && a == b && b == c) {
                return a;
            }
        }
        return ' ';
    }

    public boolean isFull() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }
}