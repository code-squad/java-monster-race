import java.util.Set;
import java.util.TreeMap;

public class Status {

    public Set showStatus(int monster, int tryNumber) {
        Location location = new Location();
        TreeMap<String, Integer> monsterMap = new TreeMap<>();

        for (int i = 0; i < monster; i++) {
            monsterMap.put((i + 1) + "번몬스터", location.computeLocation(tryNumber));
        }
        return monsterMap.entrySet();
    }
}
