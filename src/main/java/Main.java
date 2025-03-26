import Controller.GameController;
import Models.Bot;
import Models.BotDifficultyLevel;
import Models.Player;
import Models.PlayerType;

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
            System.out.println("Enter the Name of the Player");
            String name= in.next();
            System.out.println("Enter the Symbol of the Player");
            char symbol = in.next().charAt(0);
            playerList.add(new Player(name,symbol,PlayerType.HUMAN));
        }
        if (isBotString.equals("y")){
            System.out.println("Enter the Name of the BOT");
            String name= in.next();
            System.out.println("Enter the Symbol of the BOT");
            char symbol = in.next().charAt(0);
            playerList.add(new Bot(name,symbol, BotDifficultyLevel.EASY));
        }
        //we can add more strategies
        String strategies="Orderone";
        gameController.StartGame(Size,playerList,strategies);



    }

}
