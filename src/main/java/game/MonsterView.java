package game;

/**
 * 주어진 몬스터 정보를 이용해 콘솔로 출력한다.
 */
public class MonsterView {
    public static void printResult(Monster[] monsters) {
        for(Monster monster: monsters) {
            StringBuilder builder = new StringBuilder();

            int count = monster.getDistance();
            for(int i=0; i<count; i++)
                builder.append("-");

            System.out.println(builder.toString());
        }
    }
}
