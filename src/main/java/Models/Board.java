package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;

    private List<List<Cell>> board;

    public List<List<Cell>> getBoard() {
        return board;
    }
    public int getSize() {
        return size;
    }

    public Board (int size){
        this.size=size;
        this.board=new ArrayList<>();
        for(int i=0;i<size;i++){
            this.board.add(new ArrayList<>());
            for (int j=0;j<size;j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void display(){
        for (int i=0; i < size; i++){
            System.out.println("_______________ ");
            for (int j=0;j< size;j++) {
                if (board.get(i).get(j).getState().equals(CellState.EMPTY)) {
                    System.out.print("|   |");
                } else {
                    System.out.print("| " + board.get(i).get(j).getPlayer().getSymbol() + " |");
                }
            }System.out.println();
        }System.out.println("_______________ ");
    }
}
