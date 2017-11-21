public class enemyPiece extends Piece {

    boolean playerPiece;

    public enemyPiece(int startX, int startY, int startStrength, String startType) {
        super(startX, startY, startStrength, startType);
        this.playerPiece = false;
    }
}