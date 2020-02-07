import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster {
    private String name;
    private String vehicle;
    public int moves;

    public Monster() {
    }

    public void oneStepForward() {
        this.moves += 1;
    }

    public void printOneMonsterLocation(Monster monster) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < monster.moves; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }

    public void printAllMonsterLocation() {
        for (Monster m : Race.monsters) {
            printOneMonsterLocation(m);
        }
    }
}