import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class T3Test {
    T3 model = new T3();

    @org.junit.jupiter.api.Test
    void getPosition() {
        T3.Player[][] board = model.getBoard();
        board[2][1] = T3.Player.X;
        assertEquals(T3.Player.X,model.getPosition(2,1));
    }


    @org.junit.jupiter.api.Test
    void getCurrentPlayer() {
        model.setCurrentPlayer(T3.Player.X);
        assertEquals(T3.Player.X, model.getCurrentPlayer());
    }

    @org.junit.jupiter.api.Test
    void switchPlayer() {
        model.setCurrentPlayer(T3.Player.X);
        model.switchPlayer();
        assertEquals(T3.Player.O, model.getCurrentPlayer());
    }

    @org.junit.jupiter.api.Test
    void getWinner() {
        model.setCurrentPlayer(T3.Player.X);
        model.makeMove(0,0);
        model.makeMove(1,1);
        model.makeMove(2,2);
        assertEquals(T3.Player.X, model.getWinner());
        model.clearBoard();
        model.setCurrentPlayer(T3.Player.X);
        model.makeMove(0,0);
        model.makeMove(0,1);
        model.makeMove(0,2);
        assertEquals(T3.Player.X, model.getWinner());
    }

    @org.junit.jupiter.api.Test
    void clearBoard() {
        model.setCurrentPlayer(T3.Player.X);
        model.makeMove(0,0);
        model.makeMove(0,1);
        model.clearBoard();
        assertEquals(model.getPosition(0,0), T3.Player.NONE);
        assertEquals(model.getPosition(0,1), T3.Player.NONE);

    }

    @org.junit.jupiter.api.Test
    void isDraw() {
        model.setCurrentPlayer(T3.Player.X);
        model.makeMove(0,0);
        model.switchPlayer();
        model.makeMove(0,1);
        model.switchPlayer();
        model.makeMove(0,2);
        model.switchPlayer();
        model.makeMove(1,0);
        model.switchPlayer();
        model.makeMove(1,2);
        model.switchPlayer();
        model.makeMove(1,1);
        model.switchPlayer();
        model.makeMove(2,0);
        model.switchPlayer();
        model.makeMove(2,2);
        model.switchPlayer();
        model.makeMove(2,1);
        assertTrue(model.isDraw());

    }

    @Test
    void makeMove() {
        model.setCurrentPlayer(T3.Player.X);
        model.makeMove(0,1);
        assertEquals(T3.Player.X, model.getPosition(0,1));
    }

    @Test
    void getBoard() {
        T3.Player[][] board = model.getBoard();
        assertEquals(board,model.getBoard());
    }

    @Test
    void setCurrentPlayer() {
        model.setCurrentPlayer(T3.Player.X);
        assertEquals(T3.Player.X, model.getCurrentPlayer());
    }
}