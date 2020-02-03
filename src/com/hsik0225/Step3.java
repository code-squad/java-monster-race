package com.hsik0225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Step3 {
    Scanner scanner;
    Random random;
    HashMap<String, String> MonsterInfoMap;
    HashMap<String, String> moveLengthMap;


    public Step3() {
        scanner = new Scanner(System.in);
        random = new Random();
        MonsterInfoMap = new HashMap<>();
        moveLengthMap = new HashMap<>();

        setGame();

        scanner.close();
    }

    public void setGame() {
        final int MONSTER_COUNT = setMonsterCount();
        final int CHALLENGE_COUNT = setChallengeNumber();
        setMonsterInfoMap(MONSTER_COUNT);
        setMoveLengthMap(MONSTER_COUNT, CHALLENGE_COUNT);
        changeNullValue();
        String winner = checkWinner();
        startGame(winner);
    }

    public int setMonsterCount() {
        System.out.println("몬스터는 모두 몇 명인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public int setChallengeNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public void setMonsterInfoMap(int MONSTER_COUNT) {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분");

        IntStream.range(0, MONSTER_COUNT).forEach(count -> {
            String[] inputMonsterInfo = scanner.nextLine().replace(" ", "").split(",");
            MonsterInfoMap.put(inputMonsterInfo[0], inputMonsterInfo[1]);
        });
    }

    public void setMoveLengthMap(int MONSTER_COUNT, int CHALLENGE_COUNT) {
        IntStream.range(0, CHALLENGE_COUNT)
                .map(count -> random.nextInt(10))
                .forEach(randomValue -> {
                    putValue(MONSTER_COUNT, randomValue);
                });
    }

    public void putValue(int MONSTER_COUNT, int randomValue) {
        String[] monsterType = {"에스퍼", "비행", "달리기"};
        int[] conditionValue = {9, 6, 4};
        int[] range = {random.nextInt(100) + 1, 3, 1};

        IntStream.range(0, MONSTER_COUNT)
                .filter(index -> randomValue >= conditionValue[index])
                .forEach(index -> {
                    moveLengthMap.put(monsterType[index], moveLengthMap.get(monsterType[index]) + moveMonster(range[index]));
                });
    }

    public String moveMonster(int range) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, range).forEach(index -> result.append("-"));
        return result.toString();
    }

    public String checkWinner() {
        int maxLength = 0;
        String winner = "";

        for (String key : MonsterInfoMap.keySet()) {
            int lengthLength = moveLengthMap.get(MonsterInfoMap.get(key)).length();

            if (lengthLength > maxLength) {
                maxLength = lengthLength;
                winner = key;
            }
        }
        return winner;
    }

    public void changeNullValue() {
        MonsterInfoMap.keySet()
                .stream()
                .map(MonsterInfoMap::get)
                .filter(lengthMapKey -> moveLengthMap.get(lengthMapKey) == null)
                .forEach(lengthMapKey -> moveLengthMap.put(lengthMapKey, "null"));
    }

    public void startGame(String winner) {
        int nullIndex = 4;

        System.out.println("<경기 시작>\n");

        MonsterInfoMap.keySet()
                .forEach(key -> System.out.println(key + " [ " + MonsterInfoMap.get(key) + " ] : " + moveLengthMap.get(MonsterInfoMap.get(key)).substring(nullIndex)));

        System.out.println("축하합니다! " + winner + "가 몬스터 레이스에서 우승했습니다.");
    }
}
