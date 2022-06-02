
public class Rectangle {
   
    protected Position position;
   
    protected int width;
   
    protected int height;

    public Rectangle(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int x, int y, int width, int height) {
        this(new Position(x,y),width,height);
    }
    public int getHeight() {
        return height;
    }

    
    public int getWidth() {
        return width;
    }

   
    public Position getPosition() {
        return position;
    }

  
    public boolean isPositionInside(Position targetPosition) {
        return targetPosition.x >= position.x && targetPosition.y >= position.y
                && targetPosition.x < position.x + width && targetPosition.y < position.y + height;
    }
}
