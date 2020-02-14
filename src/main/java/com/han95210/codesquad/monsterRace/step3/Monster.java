package com.han95210.codesquad.monsterRace.step3;

public class Monster {
    public String[] monstersName;
    public String[] monstersSpecies;

    public Monster(String[] monstersNameAndSpecies) {
        monstersName = new String[monstersNameAndSpecies.length];
        monstersSpecies = new String[monstersNameAndSpecies.length];
        splitString(monstersNameAndSpecies);
    }

    // monstersNameAndSpecies[i] = "몬스터명,몬스터종류" 형태를 분리하기
    private void splitString(String[] monstersNameAndSpecies) {
        for (int i = 0; i < monstersNameAndSpecies.length; i++) {
            int locationComma = monstersNameAndSpecies[i].indexOf(",");
            monstersName[i] = monstersNameAndSpecies[i].substring(0,locationComma).trim();
            monstersSpecies[i] = monstersNameAndSpecies[i].substring(locationComma+1).trim();
        }
    }
}
