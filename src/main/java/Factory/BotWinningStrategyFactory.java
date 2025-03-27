package Factory;

import Models.Bot;
import Models.BotDifficultyLevel;
import Strategies.BotWinningStrategy.BotWinningStrategy;

public class BotWinningStrategyFactory {
    public static BotWinningStrategy getStrategy(BotDifficultyLevel  level){
        if (level.equals(BotDifficultyLevel.EASY)){
            return new BotWinningStrategy();
        }
        return null;
    }
}
