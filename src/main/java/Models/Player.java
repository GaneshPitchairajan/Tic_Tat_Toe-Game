package Models;

public class Player {
    String Name;
    char Symbol;
    PlayerType Type;
    Player(){

    }
    public Player(String name,char symbol,PlayerType type){
        this.Name=name;
        this.Symbol=symbol;
        this.Type=type;
    }
}
