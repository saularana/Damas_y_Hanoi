package git.ipc1.Models.damas;
import git.ipc1.Models.damas.PotitionsMove.Direction;


public abstract class Ficha  implements PotitionsMove{

    private int colum;
    private int row;
    private boolean show;

    public Ficha(int row, int colum) {
        this.row = row;
        this.colum = colum;

    }

    public Ficha(int row, int colum, boolean show) {
        this.row = row;
        this.colum = colum;
        this.show = show;
    }

    public int getColum() {
        return this.colum;
    }

    public int getRow() {
        return this.row;
    }

    public boolean isShow() {
        return this.show;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean setPotition(int row, int colum) {
        if (checkPotition(row, colum)) {
            this.row = row;
            this.colum = colum;
            this.show = false;
        }else{
        this.show = true;
        }
        return this.show;
    }
    private static boolean checkPotition (int row, int colum){
    return (row > 0 && colum > 0 && row + colum % 2 != 0);
    }
    
    public int potitionColum(Direction d){    
        if (null==d)
                return colum;
        else return switch (d) {
            case RIGHT -> colum+1;
            case LEFT -> colum-1;
            default -> colum;
        };
    }
    protected abstract int potitionRow();

    @Override
    public String toString() {
        return "("+this.getRow()+","+this.getColum()+")"+((this.isShow())?"Hide":"");
    }
    
    
    

}
