package Strategies.BotWinningStrategy;

import Models.Board;
import Models.Move;
import Models.Player;

public interface BotStrategy {
    Move BotDecidemove(Player player, Board board);

}
