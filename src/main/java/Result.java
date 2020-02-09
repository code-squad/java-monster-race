import java.util.List;

public class Result {

    public void printOneMonsterLocation(Monster monster) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < monster.getMoves(); i++) {
            sb.append("-");
        }  System.out.println(monster.getName() + " [" + monster.getType() + "]" +  sb);
    }

    public void printAllMonsterLocation(List<Monster> monsters) {
        for (Monster m : monsters) {
            printOneMonsterLocation(m);
        }
    }
}
