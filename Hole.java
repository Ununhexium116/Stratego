public class Hole extends Piece{

    boolean hole = true;

    public Hole(int startX, int startY, int startStregnth, boolean startHole) {
        super(startX, startY, startStregnth);
        this.hole = startHole;
    }

    // Setter
    public void setHole(boolean holeInput) {
        this.hole = holeInput;
    }

    // Getter
    public boolean getHole() {
        return this.hole;
    }
}
