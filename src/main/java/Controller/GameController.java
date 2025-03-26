package Controller;

import Models.Game;
import Models.Player;

import java.util.List;

public class GameController {
    public void StartGame(int Size, List<Player> players, String strategyname){
        try {
            Game.getBuilder()
                    .setSize(Size)
                    .setPlayers(players)
                    .setStrategy(strategyname).Build();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;



    }
}
