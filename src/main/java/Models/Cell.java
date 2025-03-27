package Models;

public class Cell {
    private int row;
    private int column;
    private Player player;
    private CellState state;
    public Cell(int row,int column){
        this.row=row;
        this.column=column;
        this.state=CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public CellState getState() {
        return state;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}