public class playerPiece extends Piece{

    boolean playerPiece;

    public playerPiece(int startX, int startY, int startStrength, String startType) {
        super(startX, startY, startStrength, startType);
        this.playerPiece = true;
    }
}
