import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JFrame {
    private GameState state;
    private JButton[] cells = new JButton[9];
    private JLabel statusLabel = new JLabel();

    public GamePanel() {
        state = new GameState();

        setTitle("Tic-Tac-Toe");
        setSize(400, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(statusLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 4, 4));
        for (int i = 0; i < 9; i++) {
            final int index = i;
            JButton btn = new JButton("");
            btn.setFont(new Font("SansSerif", Font.BOLD, 48));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleMove(index);
                }
            });
            cells[i] = btn;
            boardPanel.add(btn);
        }
        add(boardPanel, BorderLayout.CENTER);

        JButton restartBtn = new JButton("restart game");
        restartBtn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        restartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.reset();
                refreshBoard();
            }
        });
        add(restartBtn, BorderLayout.SOUTH);
        refreshBoard();
        setVisible(true);
    }

    private void handleMove(int index) {
        if (state.isGameOver()) return;
        if (!state.makeMove(index)) return;
        refreshBoard();

        char winner = state.checkWinner();
        if (winner != ' ') {
            statusLabel.setText("ENDGAME : " + winner + " WIN!");
            JOptionPane.showMessageDialog(this, "WINNER IS : " + winner);
        } else if (state.isFull()) {
            statusLabel.setText("ENDGAME : DRAW!");
            JOptionPane.showMessageDialog(this, "GAME DRAW!");
        }
    }

    private void refreshBoard() {
        char[] board = state.getBoard();
        for (int i = 0; i < 9; i++) {
            cells[i].setText(board[i] == ' ' ? "" : String.valueOf(board[i]));
            cells[i].setEnabled(board[i] == ' ' && !state.isGameOver());
        }
        if (!state.isGameOver()) {
            statusLabel.setText("Turn : " + state.getCurrentPlayer());
        }
    }

    public static void main(String[] args) {
        new GamePanel();
    }
}