public class enemyPiece extends Piece {

    boolean playerPiece;

    public enemyPiece(int startX, int startY, int startStrength) {
        super(startX, startY, startStrength);
        this.playerPiece = false;
    }
}