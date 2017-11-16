public class playerPiece extends Piece{

    boolean playerPiece;

    public playerPiece(int startX, int startY, int startStrength) {
        super(startX, startY, startStrength);
        this.playerPiece = true;
    }
}
