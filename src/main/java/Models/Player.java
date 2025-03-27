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
        System.out.println("Which row you want to move");
        int row=scanner.nextInt();
        System.out.println("which column you want to move");
        int column=scanner.nextInt();
        Cell cell=board.getBoard().get(row).get(column);
        return new Move(this,cell);

    }
}
