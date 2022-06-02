import java.awt.*;

public class StatusPanel extends Rectangle {

    private final Font font = new Font("Arial", Font.BOLD, 20);

    private final String placingShipLine1 = "Coloca tus barcos abajo";

    private final String placingShipLine2 = "Z para rotar.";

    private final String gameOverLossLine = "Has perdido ";

    private final String gameOverWinLine = "Hundiste sus barcos , Has Ganado";

    private final String gameOverBottomLine = "Presiona R para reiniciar.";

    private String topLine;

    private String bottomLine;

    public StatusPanel(Position position, int width, int height) {
        super(position, width, height);
        reset();
    }

    public void reset() {
        topLine = placingShipLine1;
        bottomLine = placingShipLine2;
    }

    public void showGameOver(boolean playerWon) {
        topLine = (playerWon) ? gameOverWinLine : gameOverLossLine;
        bottomLine = gameOverBottomLine;
    }

    public void setTopLine(String message) {
        topLine = message;
    }

    public void setBottomLine(String message) {
        bottomLine = message;
    }

    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(position.x, position.y, width, height);
        g.setColor(Color.BLACK);
        g.setFont(font);
        int strWidth = g.getFontMetrics().stringWidth(topLine);
        g.drawString(topLine, position.x + width / 2 - strWidth / 2, position.y + 20);
        strWidth = g.getFontMetrics().stringWidth(bottomLine);
        g.drawString(bottomLine, position.x + width / 2 - strWidth / 2, position.y + 40);
    }
}
