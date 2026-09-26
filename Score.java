import java.io.File;
import java.util.Map;

public class Score {

    
    private static final File SCORE_FILE = new File("score.txt");
    private static final File SAVE_FILE = new File("game_save.txt");

    

    public static Map<String, int[]> readScore() {
        
        return null;
    }

    public static void writeScore(Map<String, int[]> scores) {
        
    }

    public static void addWin(String playerName) {
        
    }

    public static void addLoss(String playerName) {
        
    }

    public static void addDraw(String playerName) {
        
    }

    public static String getScoreText() {
        
        return null;
    }

    

    public static class SavedGame {
        public final String playerX;
        public final String playerO;
        public final char[] board;
        public final char currentPlayer;

        public SavedGame(String playerX, String playerO,
                         char[] board, char currentPlayer) {
            this.playerX = playerX;
            this.playerO = playerO;
            this.board = board;
            this.currentPlayer = currentPlayer;
        }
    }

    public static void saveGame(String playerX, String playerO,
                                char[] board, char currentPlayer) {
        
    }

    public static SavedGame loadGame() {
        
        return null;
    }

    public static boolean hasSavedGame() {
        
        return false;
    }

    private static boolean isFinished(char[] board) {
        
        return false;
    }
}
