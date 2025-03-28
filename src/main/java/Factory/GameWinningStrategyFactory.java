package Factory;

import Strategies.GameWinningStrategy.GameWinningStrategy;
import Strategies.GameWinningStrategy.OrderWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getStrategy(String strategy, int size){
        if (strategy.equals("Orderone")){
            return new OrderWinningStrategy(size);
        }
        return null;
    }
}
