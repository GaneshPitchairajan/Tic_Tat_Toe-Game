package Models;

public class Bot extends Player{
    //private BotWinningStrategy botWinningStrategy;
    private BotDifficultyLevel botDifficultyLevel;
    public Bot(String Name,char Symbol,BotDifficultyLevel botdifficultylevel){
        super(Name,Symbol,PlayerType.BOT);
        this.botDifficultyLevel=botdifficultylevel;
        //this.botWinningStrategy=BotWinningStrategy;
    }

}
