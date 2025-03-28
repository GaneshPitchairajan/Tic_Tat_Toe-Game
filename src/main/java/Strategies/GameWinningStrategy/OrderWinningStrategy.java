package Strategies.GameWinningStrategy;

import Models.BotDifficultyLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderWinningStrategy implements GameWinningStrategy {
    List<HashMap<Character,Integer>>  RowCounter=new ArrayList<>();
    List<HashMap<Character,Integer>> ColumnCounter=new ArrayList<>();
    HashMap<Character,Integer> RightDiagonalCounter=new HashMap<>();
    HashMap<Character,Integer> LeftDiagonalCounter=new HashMap<>();




    public OrderWinningStrategy(int size){
        for (int i=1;i<size;i++){
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
}
