package Strategies.GameWinningStrategy;

import Models.Cell;

public interface GameWinningStrategy {
    boolean IswinningMove(char symbol, Cell cell , int size);
}
