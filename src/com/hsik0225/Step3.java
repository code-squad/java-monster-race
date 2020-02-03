package com.hsik0225;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Step3 {
    Scanner scanner = new Scanner(System.in);

    public Step3(){
        setGame();
    }

    public void setGame(){
        final int monsterCount = setMonsterCount();
        final int challengeNumber = setChallengeNumber();
        HashMap<String, String> infoMap = setMonsterInfoMap(monsterCount);
        HashMap<String, String> spaceMap = setSpaceMap(monsterCount, challengeNumber);
        String winner = checkWinner(infoMap, spaceMap);
        startGame(infoMap, spaceMap, winner);
    }
    public int setMonsterCount(){
        System.out.println("몬스터는 모두 몇 명인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public int setChallengeNumber(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public HashMap<String, String> setMonsterInfoMap(int monsterCount){
        HashMap<String, String> infoMap = new HashMap<>();
        int loopCount = monsterCount;
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분");
        while(loopCount-->0){
            String[] inputMonsterInfo = scanner.nextLine().replace(" ", "").split(",");
            infoMap.put(inputMonsterInfo[0], inputMonsterInfo[1]);
        }
        return infoMap;
    }

    public HashMap<String, String> setSpaceMap(int monsterCount, int challengeNumber){
        HashMap<String, String> spaceMap = new HashMap<>();
        Random random = new Random();
        String[] moveSpace = new String[monsterCount];
        int loopCount = challengeNumber;
        while(loopCount-->0){
            int randomValue = random.nextInt(10);
            System.out.println(randomValue);
            if(randomValue>=9){
                moveSpace[0] += moveMonster(randomValue,9,(random.nextInt(100)+1));
                spaceMap.put("에스퍼", moveSpace[0]);
            }
            if(randomValue>=6){
                moveSpace[1] += moveMonster(randomValue, 6,3);
                spaceMap.put("비행", moveSpace[1]);
            }
            if(randomValue>=4){
                moveSpace[2] += moveMonster(randomValue, 4, 1);
                spaceMap.put("달리기", moveSpace[2]);
            }
        }
        return spaceMap;
    }

    public String moveMonster(int randomValue, int conditionValue, int space){
        StringBuilder result = new StringBuilder();
        IntStream.range(0,space).forEach(index -> result.append("-"));
        return result.toString();
    }

    public String checkWinner(HashMap<String, String> infoMap, HashMap<String, String> spaceMap){
        int maxLength = 0;
        String winner = "";
        for (String key : infoMap.keySet()) {
            if(infoMap.get(key)==null){
                continue;
            }
            int spaceLength = spaceMap.get(infoMap.get(key)).length();
            if(spaceLength>maxLength){
                maxLength=spaceLength;
                winner = key;
            }
        }
        System.out.println(winner);
        return winner;
    }

    public void startGame(HashMap<String, String> infoMap, HashMap<String, String> spaceMap, String winner){
        System.out.println("<경기 시작>\n");
        int nullIndex = 4;
        for (String key : infoMap.keySet()) {
            System.out.println(key + " [ "
                    + infoMap.get(key)
                    + " ] : "
                    + spaceMap.get(infoMap.get(key)).substring(nullIndex));
        }
        System.out.println("축하합니다! " + winner + "가 몬스터 레이스에서 우승했습니다.");
    }
}
