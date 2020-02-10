import java.util.*;

public class Result {

    public void printOneMonsterLocation(Monster monster) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < monster.Moves(); i++) {
            sb.append("-");
        }
        System.out.println(monster.Name() + " [" + monster.Type() + "]" + sb);
    }

    public void printAllMonsterLocation(List<Monster> monsters) {
        for (Monster m : monsters) {
            printOneMonsterLocation(m);
        }
    }

    public void printWinner(List<Monster> monsters) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Monster m : monsters) {
            map.put(m.Name(), m.Moves());
        }
        int maxValueInMap = (Collections.max(map.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue() == maxValueInMap) {
                System.out.println("Winner is " + entry.getKey());     // Print the key with max value
            }
        }
    }
}
