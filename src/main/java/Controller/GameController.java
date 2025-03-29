package Controller;

import Models.Game;
import Models.Player;

import java.util.List;

public class GameController {
    public Game StartGame(int Size, List<Player> players, String strategyname){
        try {
            return Game.getBuilder()
                    .setSize(Size)
                    .setPlayers(players)
                    .setStrategy(strategyname).Build();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
    public void DisplayGame(Game game){
        game.Displayboard();
    }
    public void executeGame(Game game){
        game.makeNextmove();
    }
    public void undo(Game game){
        if(!game.getMoves().isEmpty()) {
            game.undo();
        }
        else{
            System.out.println("There is no Moves Left to undo");
        }
    }
    public  boolean undopossible(Game game){
        return !game.getMoves().isEmpty();
    }
}
