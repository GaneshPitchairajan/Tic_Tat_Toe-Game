package Factory;

import Strategies.GameWinningStrategy.GameWinningStrategy;
import Strategies.GameWinningStrategy.OrderWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getStrategy(String strategy){
        if (strategy.equals("Orderone")){
            return new OrderWinningStrategy();
        }
        return null;
    }
}
