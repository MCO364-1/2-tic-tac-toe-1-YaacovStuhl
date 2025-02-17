import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI extends JFrame {
    private T3 model = new T3();
    private JButton[][] buttons = new JButton[3][3];

    public TicTacToeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(new BorderLayout());//The larger Program has a border layout, while there is a separate panel for the buttons on a grid lyout
        JPanel buttonPanel = new JPanel();
        JLabel label = new JLabel("Player X's Turn");//Since Player X starts, I did it this way
        label.setFont(new Font("Calibri", Font.PLAIN, 32));
        buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));
        add(label, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);
        JButton newGame = new JButton("New Game");//Button to start a new game
        add(newGame, BorderLayout.NORTH);
        newGame.setBackground(Color.WHITE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                buttons[i][j] = button;//I made a 2D array to store the buttons on the GUI level so that when the game is over, I can clear them and reset their appearance
                final int fi = i;
                final int fj = j;
                button.setBackground(Color.WHITE);

                button.addActionListener(e -> {
                    if(model.getWinner() != T3.Player.NONE){
                        label.setText("Game is over. Please start new game");//This is a check that if the game is over, a button being pressed will have no impact
                    }
                    else {
                        model.makeMove(fi, fj);
                    button.setFont(new Font("Times New Roman", Font.PLAIN, 128));
                    if(model.getCurrentPlayer() == T3.Player.X){//this was just for fun to have the X's and O's be different colors. Just for fun
                        button.setBackground(Color.BLUE);
                    } else if (model.getCurrentPlayer() == T3.Player.O) {
                        button.setBackground(Color.RED);
                    }

                        button.setText(model.getCurrentPlayer().toString());
                        if (model.getWinner() != T3.Player.NONE) {
                            label.setText(model.getWinner().toString() + " won. New game?");//If the game is won, the label will display the winner and prompt for a new game.
                            newGame.setBackground(Color.YELLOW);
                        } else if (model.isDraw()) {
                            label.setText("The game is a draw. Please start a new game");
                            newGame.setBackground(Color.YELLOW);
                        } else {
                            model.switchPlayer();
                            label.setText(model.getCurrentPlayer().toString() + "'s turn");//If the game is not completed in any form, the game will switch to the next player
                        }
                    }
                });

                buttonPanel.add(button);
            }
        }
        newGame.addActionListener(e -> {
            model.clearBoard();
            for (int a = 0; a < 3; a++){
                for(int b = 0; b < 3; b++){
                    buttons[a][b].setText("");//This clears the text from the buttons in the array on the GUI level, and the previous clearBoard method clears it on the model level
                    buttons[a][b].setBackground(Color.WHITE);
                }
            }
            label.setText("X's turn");
            newGame.setBackground(Color.WHITE);
        });
        model.clearBoard();//This defaults all the spaces to Player.NONE as opposed to null which is the default. This would have complicated the logic in the switchPlayer method otherwise
        setVisible(true);


    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
