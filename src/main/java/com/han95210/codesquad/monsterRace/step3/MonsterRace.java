//package com.han95210.codesquad.monsterRace.step3;
//
//import java.util.Scanner;
//
//public class MonsterRace {
//
//    private MonsterRace monsterRace;
//
//
//
//    private String[] getMonstersName(int numberOfMonster, String[] monstersInfo) {
//        String[] monstersName = new String[numberOfMonster];
//
//        for (int i = 0; i < numberOfMonster; i++) {
//            String[] monsterInfo = monstersInfo[i].split(",");
//            monstersName[i] = monsterInfo[0];
//        }
//        return monstersName;
//    }
//
//    private String[] getMonstersSpecies(int numberOfMonster, String[] monstersInfo) {
//        String[] monstersSpecies = new String[numberOfMonster];
//
//        for (int i = 0; i < numberOfMonster; i++) {
//            String[] monsterInfo = monstersInfo[i].split(",");
//            monstersSpecies[i] = monsterInfo[1];
//        }
//        return monstersSpecies;
//    }
//
//
//
//    private static String getRandomDash() {
//        String dashStr = "";
//        int randomNum = (int) (Math.random() * 10);
//        if (randomNum >= 4) {
//            dashStr = "-";
//        }
//        return dashStr;
//    }
//
//    // 횟수가 주어졌을 때 랜덤으로 문자열에 -(dash)로 채워넣기
//    private static String getDashStr(int numberAttempts) {
//        StringBuilder dashStr = new StringBuilder();
//
//        for (int i = 0; i < numberAttempts; i++) {
//            dashStr.append(getRandomDash());
//        }
//        return dashStr.toString();
//    }
//
//    // 몬스터가 진행한 만큼 출력
//    private void getForwardCount(String[] monstersInfo, String[] monstersName, String[] monstersSpecies,
//                                 int numberOfMonster, int numberAttempts) {
//        monstersName = getMonstersName(numberOfMonster,monstersInfo);
//        monstersSpecies = getMonstersSpecies(numberOfMonster,monstersInfo);
//
//        System.out.println("<경기 시작>");
//        System.out.println();
//        String[] arr = new String[numberOfMonster];
//
//        for (int i = 0; i < numberOfMonster; i++) {
//            System.out.println(monstersName[i] + " ["+monstersSpecies[i]+"] : " + getDashStr(numberAttempts));
//            arr[i] = getDashStr(numberAttempts);
//        }
//    }
//
//    private void start() {
//        monsterRace= new MonsterRace();
//        String[] monstersName;
//        String[] monstersSpecies;
//
//        System.out.println("<신나는 몬스터 레이스>");
//        // 몬스터 수 입력받기
//        int numberOfMonster = monsterRace.getNumberOfMonster();
//        System.out.println(numberOfMonster);
//        System.out.println();
//
//        String[] monstersInfo = getMonsterNameAndSpecies(numberOfMonster);
//
//        // 몬스터 이름과 종류 입력받기
//        monstersName = monsterRace.getMonstersName(numberOfMonster, monstersInfo);
//        monstersSpecies = monsterRace.getMonstersSpecies(numberOfMonster, monstersInfo);
//        System.out.println();
//        // 시도할 횟수 입력받기
//        int numberAttempts = monsterRace.getNumberAttempts();
//        System.out.println(numberAttempts);
//        System.out.println();
//        // 결과
//        monsterRace.getForwardCount(monstersInfo,monstersName,monstersSpecies,numberOfMonster, numberAttempts);
//    }
//
//    public static void main(String[] args) {
//        MonsterRace monsterRace = new MonsterRace();
//        monsterRace.start();
//    }
//}
