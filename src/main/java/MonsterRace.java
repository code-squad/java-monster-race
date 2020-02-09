import java.util.ArrayList;
import java.util.List;

public class MonsterRace {

    private int rounds;
    private List<Monster> monsters= new ArrayList<>();

    public MonsterRace(int countOfMonsters, int rounds) {
        initMonster(countOfMonsters);
        this.rounds = rounds;
    }

    public void start() {
        System.out.println("<레이스 시작!>");

        for(int i = 1; i <= this.rounds; ++i) {
            System.out.println("<" + i + "회>");
            updateRound();
        }
    }

    private void initMonster(int countOfMonster) {
        for(int i = 0; i < countOfMonster; ++i)
            monsters.add(new Monster());
    }

    private void updateRound() {
        for(Monster monster : monsters) {
            monster.update();
            monster.render();
        }
    }
}
