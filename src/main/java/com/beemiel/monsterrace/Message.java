package com.beemiel.monsterrace;

public class Message {

    final String TITLE = "<MONSTER RACE>";
    final String START = "\n레이스 시작";
    final String MONSTER = "몬스터는 모두 몇 마리인가요?";
    final String MONSTER_INFO = "\n경주할 몬스터 이름과 종류를 입력하세요 (예> 크롱,FLY)";
    final String TRY = "\n시도할 회수는 몇 회 인가요?";
    final String RESULT = "\n<결  과>";
    final String CLOSE = "\n<경기 종료>";

    public void gameTitle(){
        System.out.println(TITLE);
    }

    public void gameStart(){
        System.out.println(START);
    }

    public void getMonster(){
        System.out.println(MONSTER);
    }

    public void monsterInfo(){
        System.out.println(MONSTER_INFO);
    }

    public void getTry(){
        System.out.println(TRY);
    }

    public void result(){
        System.out.println(RESULT);
    }

    public void gameClose(){
        System.out.println(CLOSE);
    }

}
