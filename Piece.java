public class Piece {
    int value = 0;
    int x = 0;
    int y = 0;
    boolean player;

    // Default Constructor
    public static void piece(int X, int Y, boolean playerPiece, int Strength) {
        this.x = X;
        this.y = Y;
        this.player = playerPiece;
        this.value = Strength;
    }

    // Setters
    public static void setX(int X) {
        this.x = X;
    }

    public static void setY(int Y) {
        this.y = Y;
    }

    public static void setPlayer(boolean inputPlayer) {
        this.player = inputPlayer;
    }

    public static void setValue(int inputValue) {
        this.value = inputValue;
    }

    // Getters
    public static int getX() {
        return this.x;
    }

    public static int getY() {
        return this.y;
    }

    public static boolean getPlayer() {
        return this.player;
    }

    public static int getValue() {
        return this.value;
    }
}
