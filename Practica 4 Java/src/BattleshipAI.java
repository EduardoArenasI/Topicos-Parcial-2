import java.util.ArrayList;
import java.util.List;

 
public class BattleshipAI {
    
    protected SelectionGrid playerGrid;
    
    protected List<Position> validMoves;

    
    public BattleshipAI(SelectionGrid playerGrid) {
        this.playerGrid = playerGrid;
        createValidMoveList();
    }

   
    public Position selectMove() {
        return Position.ZERO;
    }

    
    public void reset() {
        createValidMoveList();
    }

   
    private void createValidMoveList() {
        validMoves = new ArrayList<>();
        for(int x = 0; x < SelectionGrid.GRID_WIDTH; x++) {
            for(int y = 0; y < SelectionGrid.GRID_HEIGHT; y++) {
                validMoves.add(new Position(x,y));
            }
        }
    }
}
