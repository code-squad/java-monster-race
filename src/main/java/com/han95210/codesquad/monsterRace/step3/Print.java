package com.han95210.codesquad.monsterRace.step3;

import java.util.Arrays;

public class Print {

    public Print(String[] monstersName, String[] monstersSpecies, String[] numberMovements) {
        printStart();
        printResult(monstersName,monstersSpecies,numberMovements);
        printWinner(monstersName,numberMovements);
    }

    private void printStart() {
        System.out.println("\n<경기 시작>\n");
    }

    private void printResult(String[] monstersName, String[] monstersSpecies, String[] numberMovements) {
        for (int i = 0; i < monstersName.length; i++) {
            System.out.println(monstersName[i] + " [" + monstersSpecies[i] +"] : " + numberMovements[i]);
        }
    }

    // 제일 많이 전진한 몬스터 출력하기
    private String printWinnerName(String[] monstersName,String[] numberMovements) {
        String[] monstersNameAndMovements = new String[monstersName.length];
        for (int i = 0; i < monstersNameAndMovements.length; i++) {
            monstersNameAndMovements[i] = monstersName[i] + "," + numberMovements[i];
        }
        Arrays.sort(numberMovements);
        int checkedError = 1;

        for (int k = 0; k < numberMovements.length; k++) {
            if (numberMovements[numberMovements.length - checkedError].equals("No result")) {
                checkedError++;
            }
        }
        if (checkedError == numberMovements.length) {
            return "오류(No result)";
        }
        for (int i = 0; i < monstersNameAndMovements.length; i++) {
            if (monstersNameAndMovements[i].contains(numberMovements[numberMovements.length - checkedError])) {
                return monstersNameAndMovements[i].substring(0, monstersName[i].length());
            }
        }
        return "예외";
    }

    private void printWinner(String[] monstersName,String[] numberMovements) {
        System.out.println("\n축하합니다! " + printWinnerName(monstersName,numberMovements) +" (이)가 몬스터 레이스에서 우승했습니다.");
    }
}
