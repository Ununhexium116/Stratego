public class Piece {
    private int x = 0;
    private int y = 0;
    private boolean player;

    // Default Constructor
    public Piece(int X, int Y, boolean playerPiece) {
        this.x = X;
        this.y = Y;
        this.player = playerPiece;
    }

    // Setters
    public void setX(int X) {
        this.x = X;
    }

    public void setY(int Y) {
        this.y = Y;
    }

    public void setPlayer(boolean inputPlayer) {
        this.player = inputPlayer;
    }

    // Getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getPlayer() {
        return this.player;
    }
}
