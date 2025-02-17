public class T3 {
    private Player[][] board = new Player[3][3];

    public enum Player {
        X, O, NONE
    }
    private Player currentPlayer = Player.X;//There has to be a player whose turn it is

    public Player getPosition(int row, int col) {
        if(row > 2 || row < 0 || col > 2 || col < 0){
            throw new IndexOutOfBoundsException();
        }
        return board[row][col];
    }

    public void makeMove(int row, int col) throws IllegalArgumentException {
        if(getPosition(row, col) == Player.X || getPosition(row, col) == Player.O){
            throw new IllegalArgumentException();
        }
        board[row][col] = getCurrentPlayer();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer(){
        if(currentPlayer == Player.X){
            currentPlayer = Player.O;
        } else if (currentPlayer == Player.O) {
            currentPlayer = Player.X;
        }
    }

    public Player getWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Player.NONE && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {//Checks rows for victory
                return board[i][0];

            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != Player.NONE && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {//Checks columns for victory
                return board[0][i];
            }
        }


        if (board[0][0] != Player.NONE && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {//each one checks diagonals for victory
            return board[0][0];
        }
        if (board[0][2] != Player.NONE && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return Player.NONE;
    }

    public void clearBoard(){//This method resets everything in the model to Player.NONE and resets the currentplayer to Player.X as is the default
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Player.NONE;
            }
        }
        currentPlayer = Player.X;
    }

    public boolean isDraw(){//This checks for a draw. If any element on the board is Player.NONE then nobody has claimed it and so the game is not a draw
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == Player.NONE){
                    isDraw = false;
                }
            }
        }
        return isDraw;
    }
}
