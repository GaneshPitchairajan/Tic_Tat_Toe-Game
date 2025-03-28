package Models;

import java.util.Scanner;

public class Player {
    String Name;
    char Symbol;
    PlayerType Type;
    Scanner scanner;
    public Player(String name,char symbol,PlayerType type){
        this.Name=name;
        this.Symbol=symbol;
        this.Type=type;
        this.scanner=new Scanner(System.in);
    }

    public String getName() {
        return Name;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setType(PlayerType type) {
        Type = type;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public void setName(String name) {
        Name = name;
    }

    public PlayerType getType() {
        return Type;

    }
    public Move decideMove (Board board){
        boolean Valid=false;
        int row=0;
        int column=0;
        while(!Valid)
        {
            System.out.println("Which row you want to move row number Starts from 0?");
            row=scanner.nextInt();
            System.out.println("Which column you want to move column number Starts from 0?");
            column=scanner.nextInt();

            if (row<board.getSize() && column<board.getSize() && row>=0 && column>=0)
            {
                Valid=true;
            }
            else{
                System.out.printf("Enter Column with in the Limit 0 to %d ",board.getSize()-1);

            }
        }
        Cell cell=board.getBoard().get(row).get(column);
        return new Move(this,cell);

    }
}
