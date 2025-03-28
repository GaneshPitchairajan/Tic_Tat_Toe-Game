package Strategies.GameWinningStrategy;

import Models.BotDifficultyLevel;
import Models.Cell;
import org.w3c.dom.html.HTMLLegendElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderWinningStrategy implements GameWinningStrategy {
    List<HashMap<Character,Integer>>  RowCounter=new ArrayList<>();
    List<HashMap<Character,Integer>> ColumnCounter=new ArrayList<>();
    HashMap<Character,Integer> RightDiagonalCounter=new HashMap<>();
    HashMap<Character,Integer> LeftDiagonalCounter=new HashMap<>();




    public OrderWinningStrategy(int size){
        for (int i=0;i<size;i++){
            RowCounter.add(new HashMap<>());
            ColumnCounter.add(new HashMap<>());
        }
    }

    public Boolean IsinRightdiagonal(int row,int column){
        return row == column;
    }

    public Boolean IsinLeftDiagonal(int row,int column,int size){
        return size-1 == (row+column);
    }


    @Override
    public boolean IswinningMove(char symbol, Cell cell, int size) {
        int row=cell.getRow();
        int column= cell.getColumn();


        if (!RowCounter.get(row).containsKey(symbol)){
            RowCounter.get(row).put(symbol,0);
        }
        RowCounter.get(row).put(symbol,RowCounter.get(row).get(symbol)+1);

        if (!ColumnCounter.get(column).containsKey(symbol)){
            ColumnCounter.get(column).put(symbol,0);
        }
        ColumnCounter.get(column).put(symbol,ColumnCounter.get(column).get(symbol)+1);


        if (IsinLeftDiagonal(row,column,size)) {
            if (!LeftDiagonalCounter.containsKey(symbol)) {
                LeftDiagonalCounter.put(symbol, 0);
            }
            LeftDiagonalCounter.put(symbol, LeftDiagonalCounter.get(symbol) + 1);

        }

        if (IsinRightdiagonal(row,column)) {
            if (!RightDiagonalCounter.containsKey(symbol)) {
                RightDiagonalCounter.put(symbol, 0);
            }
            RightDiagonalCounter.put(symbol, RightDiagonalCounter.get(symbol) + 1);
        }

        if (RowCounter.get(row).get(symbol)==size || (ColumnCounter.get(column).get(symbol) ==size)){
            return true;
        }

        if (IsinLeftDiagonal(row,column,size)){
            return LeftDiagonalCounter.get(symbol)==size;

        }

        if (IsinRightdiagonal(row,column)){
            return RightDiagonalCounter.get(symbol)==size ;
        }
        return false;

    }
}
