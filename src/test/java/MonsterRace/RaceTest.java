package MonsterRace;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class RaceTest {
  Race race;
  int monsterCnt;
  String inputMonster;
  int roundCnt;
  String inputString;

  InputStream in;

  @BeforeEach
  void setUp() {}

  @Test
  void resultsOfMatch() {
    monsterCnt = 8;
    roundCnt = 9;
    inputString = monsterCnt + "\n" + roundCnt + "\n";

    in = new ByteArrayInputStream(inputString.getBytes());
    System.setIn(in);

    race = new Race();
    race.doRace();
    //        race.resultsOfMatch();
  }

  @Test
  void resultsOfMatch2() {
    monsterCnt = 3;
    inputMonster = "크롱, 달리기\n" + "포비, 비행\n" + "호눅스, 에스퍼";
    roundCnt = 10;
    inputString = monsterCnt + "\n" + inputMonster + "\n" + roundCnt + "\n";

    in = new ByteArrayInputStream(inputString.getBytes());
    System.setIn(in);

    race = new Race();
    race.doRace();
    //        race.resultsOfMatch();
  }
}
