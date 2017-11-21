public class Piece {
    private int x = 0;
    private int y = 0;
    private int strength;
    private String type;

    // Default Constructor
    public Piece(int X, int Y, int strength, String type) {
        this.x = X;
        this.y = Y;
        this.strength = strength;
        this.type = type;
    }

    // Setters
    public void setX(int X) {
        this.x = X;
    }

    public void setY(int Y) {
        this.y = Y;
    }

    public void setStrength(int inputPlayer) {
        this.strength = inputPlayer;
    }

    // Getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getStrength() {
        return this.strength;
    }
}
