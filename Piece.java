public class Piece {
    private int value = 0;
    private int x = 0;
    private int y = 0;
    private boolean player;

    // Default Constructor
    public void piece(int X, int Y, boolean playerPiece, int Strength) {
        this.x = X;
        this.y = Y;
        this.player = playerPiece;
        this.value = Strength;
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

    public void setValue(int inputValue) {
        this.value = inputValue;
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

    public int getValue() {
        return this.value;
    }
}
