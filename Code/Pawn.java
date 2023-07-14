public class Pawn extends Piece {
    public Pawn (int x, int y, Side side, Board board) {
        super(x,y,side,board);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        // check the pawn's side
        // check if it want to move diagonally or not
        // check if it can move 2 steps or not
        if (this.getSide() == Side.WHITE){
            if (this.x == destX) {
                if (this.y == 6) { return (this.y - destY <= 2) && (this.y >= destY) && this.board.get(destX,destY) == null; }
                if (this.y < 6)  { return (this.y - destY <= 1) && (this.y >= destY) && this.board.get(destX,destY) == null; }
            }
            else if (Math.abs(this.x - destX) == 1) {
                if (this.board.get(destX, destY) != null) { return (this.y - destY == 1) && (board.get(destX, destY).getSide() == Side.BLACK); }
                else return false;
            }
            else { return false; }
        }
        else{
            if (this.x == destX) {
                if (this.y == 1) { return (destY - this.y <= 2) && (destY > this.y) && this.board.get(destX,destY) == null; }
                if (this.y > 1)  { return (destY - this.y <= 1) && (destY > this.y) && this.board.get(destX,destY) == null; }
            }
            else if (Math.abs(this.x - destX) == 1) {
                if (this.board.get(destX, destY) != null) { return (destY - this.y == 1 && board.get(destX, destY).getSide() == Side.WHITE); }
                else return false;
            }
            else { return false; }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return this.getSide() == Side.BLACK ? "♟" : "♙";
    }
}