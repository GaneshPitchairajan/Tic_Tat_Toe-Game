package Strategies.BotWinningStrategy;

import Models.*;

public class BotWinningStrategy implements BotStrategy {

    @Override
    public Move BotDecidemove(Player player, Board board) {
        int size=board.getSize();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if (board.getBoard().get(i).get(j).getState().equals(CellState.EMPTY)){
                    Cell cell  =board.getBoard().get(i).get(j);
                    return new Move(player,cell);
                }
            }
        }
        return null;
    }

}
