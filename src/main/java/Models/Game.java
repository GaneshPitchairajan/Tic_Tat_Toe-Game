package Models;

import Factory.GameWinningStrategyFactory;
import Strategies.GameWinningStrategy.GameWinningStrategy;
import Strategies.GameWinningStrategy.OrderWinningStrategy;
import Exception.InvalidGameConstructorException;

import java.util.List;

public class Game {
    private List<Player> players;
    private Player winner;
    private List<Move> moves;
    private Board board;
    private GameState state;
    private int nextplayerindex;
    private OrderWinningStrategy gameWinningStrategy;
    Game(){
    }
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }


    public static class GameBuilder {
        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setStrategy(String strategyname) {
            this.strategy = GameWinningStrategyFactory.getStrategy(strategyname);
            return this;
        }

        public GameBuilder setSize(int size) {
            this.size = size;
            return this;
        }
        private void validate() throws InvalidGameConstructorException {
            if (this.size<3){
                throw new InvalidGameConstructorException("The Size of the Board is Less than 3");
            }
        }
        private List<Player> players;
        private GameWinningStrategy strategy;
        private int size;
        public Game Build throws InvalidGameConstructorException(){
            validate();



        }
    }


}


