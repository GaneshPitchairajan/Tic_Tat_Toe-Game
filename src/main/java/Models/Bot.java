package Models;

import Factory.BotWinningStrategyFactory;
import Strategies.BotWinningStrategy.BotStrategy;
import Strategies.BotWinningStrategy.BotWinningStrategy;

public class Bot extends Player{
    private BotStrategy botWinningStrategy;
    private BotDifficultyLevel botDifficultyLevel;
    public Bot(String Name,char Symbol,BotDifficultyLevel botdifficultylevel){
        super(Name,Symbol,PlayerType.BOT);
        this.botDifficultyLevel=botdifficultylevel;
        this.botWinningStrategy= BotWinningStrategyFactory.getStrategy(botdifficultylevel);
    }
    public Move decideMove(Board board){
        return botWinningStrategy.BotDecidemove(this,board);
    }
}
