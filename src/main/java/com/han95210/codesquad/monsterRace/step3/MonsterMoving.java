package com.han95210.codesquad.monsterRace.step3;

public class MonsterMoving {
    public String[] numberMovements;

    public MonsterMoving(String[] monstersSpecies, int numberAttempts) {
        numberMovements = new String[monstersSpecies.length];
        classifyMonster(monstersSpecies, numberAttempts);
    }

    private void classifyMonster(String[] monstersSpecies, int numberAttempts) {
        for (int i = 0; i < monstersSpecies.length; i++) {
            switch(monstersSpecies[i]) {
                case "달리기":
                    numberMovements[i] = getNumberRunMovement(numberAttempts);
                    break;
                case "비행":
                    numberMovements[i] = getNumberFlyMovement(numberAttempts);
                    break;
                case "에스퍼":
                    numberMovements[i] = getNumberEsperMovement(numberAttempts);
                    break;
                default:
                    numberMovements[i] = "No result";
                    break;
            }
        }
    }

    private int getRandomValue() {
        return (int) (Math.random() * 10);
    }

    // 랜덤값이 4이상일 경우 -(dash) 반환
    private String getDashIfFourOrMore() {
        int RUN_FORWARD_NUMBER = 4;
        if (getRandomValue() >= RUN_FORWARD_NUMBER) {
            return "-";
        }
        return "";
    }

    // 랜덤값이 6이상일 경우 ---(dash) 반환
    private String getDashIfSixOrMore() {
        int FLY_FORWARD_NUMBER = 6;
        if (getRandomValue() >= FLY_FORWARD_NUMBER) {
            return "---";
        }
        return "";
    }

    // 랜덤값이 9이상인 경우 x 값 반환 (1 <= x < 100)
    private String getDashIfNineOrMore() {
        int ESPER_FORWARD_NUMBER = 9;
        StringBuilder sb = new StringBuilder();
        if (getRandomValue() >= ESPER_FORWARD_NUMBER) {
            int a = (int)((Math.random() * 100) + 1);
            for (int i = 0; i < a; i++) {
                sb.append("-");
            }
            return sb.toString();
        }
        return "";
    }

    // 횟수가 주어졌을 때 랜덤으로 문자열에 -(dash)로 채워넣기
    private String getNumberRunMovement(int numberAttempts) {
        StringBuilder dashStr = new StringBuilder();
        for (int i = 0; i < numberAttempts; i++) {
            dashStr.append(getDashIfFourOrMore());
        }
        return dashStr.toString();
    }

    // 횟수가 주어졌을 때 랜덤으로 문자열에 ---(dash)로 채워넣기
    private String getNumberFlyMovement(int numberAttempts) {
        StringBuilder dashStr = new StringBuilder();
        for (int i = 0; i < numberAttempts; i++) {
            dashStr.append(getDashIfSixOrMore());
        }
        return dashStr.toString();
    }

    // 횟수가 주어졌을 때 랜덤으로 문자열에 -(dash)로 채워넣기
    private String getNumberEsperMovement(int numberAttempts) {
        StringBuilder dashStr = new StringBuilder();
        for (int i = 0; i < numberAttempts; i++) {
            dashStr.append(getDashIfNineOrMore());
        }
        return dashStr.toString();
    }
}
