package Models;

import Factory.GameWinningStrategyFactory;
import Strategies.GameWinningStrategy.GameWinningStrategy;
import Strategies.GameWinningStrategy.OrderWinningStrategy;
import Exception.InvalidGameConstructorException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Player winner;
    private List<Move> moves;
    private Board board;
    private GameState state;
    private int nextplayerindex;
    private GameWinningStrategy gameWinningStrategy;


    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Board getBoard() {
        return board;
    }

    public GameState getState() {
        return state;
    }

    public int getNextplayerindex() {
        return nextplayerindex;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setNextplayerindex(int nextplayerindex) {
        this.nextplayerindex = nextplayerindex;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }


    Game(){
    }
    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void Displayboard(){
        this.board.display();
    }
    public void makeNextmove() {
        Player tomovePlayer = players.get(nextplayerindex);
        System.out.println("It is turn of Player:" + tomovePlayer.getName());
        boolean isvalid = false;
        Move move = null;
        while (!isvalid) {
            move = tomovePlayer.decideMove(board);
            isvalid = validateCurrentMove(move);
        }
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        System.out.printf("The row : %d  and the Column : %d is moved",row,column);
        board.getBoard().get(row).get(column).setPlayer(tomovePlayer);
        board.getBoard().get(row).get(column).setState(CellState.FILLED);

        moves.add(move);
        //updating player index
        if (gameWinningStrategy.IswinningMove(tomovePlayer.getSymbol(),move.getCell(),board.getSize()))
        {
            setWinner(tomovePlayer);
            setState(GameState.ENDED);
        }
        nextplayerindex+=1;
        nextplayerindex%=players.size();




    }
    private boolean validateCurrentMove(Move move){
        int row=move.getCell().getRow();
        int column=move.getCell().getColumn();
        int size=board.getSize();
        return row < size && column < size
                && row>=0 && column>=0 &&
                move.getCell().getState().equals(CellState.EMPTY);
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
            this.strategy = GameWinningStrategyFactory.getStrategy(strategyname,size);
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
        public Game Build() throws InvalidGameConstructorException{
            validate();
            Game game= new Game();

            game.setPlayers(players);
            game.setBoard(new Board(size));
            game.setGameWinningStrategy(strategy);
            game.setState(GameState.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setNextplayerindex(0);

            return game;
        }
    }


}


