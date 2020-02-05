package MonsterRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stadium {
    private List<Monster> playerList = new ArrayList<>();
    private int gameCnt;

    public List<Monster> getPlayerList() {
        return this.playerList;
    }

    public void playGame(Game game) {
        initStadium(game);
        this.playerList.stream()
                .forEach(monster ->{
                    movingMonster(monster,gameCnt);
                });

    }

    public void initStadium(Game game) {
        int monsterCnt = game.getMonsterCnt();
        this.gameCnt = game.getGameCnt();
        for(int i = 0; i < monsterCnt; i++){
            this.playerList.add(new Monster(i));
        }
    }

    public void movingMonster(Monster monster, int gameCnt) {
        Random random = new Random();
        int totMove = monster.getTotMove();
        int ranNum = random.nextInt(10);
        if(ranNum > 4){
            totMove += 1;
            monster.setTotMove(totMove);
        }
        if(gameCnt > 0){
            movingMonster(monster,gameCnt-1);
        }
    }

}
