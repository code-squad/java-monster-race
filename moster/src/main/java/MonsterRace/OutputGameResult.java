package MonsterRace;

import java.util.List;

public class OutputGameResult {

    public void printResult(Game game) {
        List<Monster> playerList = game.stadium.getPlayerList();
        playerList.stream()
                .forEach(monster -> {
                    System.out.println(makeDash(monster));
                });
    }

    public String makeDash(Monster monster) {
        int totMove = monster.getTotMove();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < totMove; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
