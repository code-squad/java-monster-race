package game;

import java.util.List;

// 경기 정보를 표준 출력을 통해 출력하는 책임이 있다.
public class Dashboard {
    public static void displayResult(List<Monster> monsters) {
        System.out.println();
        for(Monster monster: monsters){
            System.out.println(monster.getDistance());
        }
    }
}
