package MonsterRace;

public class Game {
    InputGameInfo inputGameInfo = new InputGameInfo();
    Stadium stadium = new Stadium();
    OutputGameResult outputGameResult = new OutputGameResult();
    private int monsterCnt;
    private int gameCnt;

    public void setMonsterCnt(String monsterCnt) {
        this.monsterCnt = Integer.parseInt(monsterCnt);
    }

    public void setGameCnt(String gameCnt) {
        this.gameCnt = Integer.parseInt(gameCnt);
    }

    public int getMonsterCnt() {
        return this.monsterCnt;
    }

    public int getGameCnt() {
        return this.gameCnt;
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.inputGameInfo.getGameInfo(game);
        game.stadium.playGame(game);
        game.outputGameResult.printResult(game);
    }

}
