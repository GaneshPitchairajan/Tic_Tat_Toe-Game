import Controller.GameController;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        GameController gameController=new GameController();

        System.out.println("Enter the Dimension of the Game: ");
        int Size= in.nextInt();

        System.out.println("Enter ('y' or 'n')  for adding a Bot in the Game: ");
        String isBotString= in.next();
        int NumberOfPlayers=Size-1;
        if (isBotString.equals("y")){
            NumberOfPlayers-=1;
        }
        List<Player> playerList=new ArrayList<>();
        for(int i=1; i<=NumberOfPlayers;i++){
            System.out.printf("Enter the Player %d Name:",i);
            String name= in.next();
            System.out.printf("Enter the Player %d Symbol:",i);
            char symbol = in.next().charAt(0);
            playerList.add(new Player(name,symbol,PlayerType.HUMAN));
        }
        if (isBotString.equals("y")){
            System.out.println("Enter the BOT Name");
            String name= in.next();
            System.out.println("Enter the BOT Symbol");
            char symbol = in.next().charAt(0);
            playerList.add(new Bot(name,symbol, BotDifficultyLevel.EASY));
        }
        //we can add more strategies
        String strategies="Orderone";
        Game game=gameController.StartGame(Size,playerList,strategies);

        while (game.getState().equals(GameState.IN_PROGRESS)){
            System.out.println("This is the current Board");
            gameController.DisplayGame(game);

            gameController.executeGame(game);

        }
        System.out.println();

        if (game.getState().equals(GameState.ENDED)){
            System.out.println("The Game is Completed");
            gameController.DisplayGame(game);
            System.out.println("The Winner is "+game.getWinner().getName());
        }
        if (game.getState().equals(GameState.DRAW)){
            System.out.println("The Game is Draw");
            gameController.DisplayGame(game);
        }

    }

}
