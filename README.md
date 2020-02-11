# java-monster-race

코드스쿼드 백엔드 자바 학습 프로젝트 1

## 프로그래밍 요구사항
* indent(인덴트, 들여쓰기) depth를 2단계에서 **1단계**로 줄여라.
   * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* **else**를 사용하지 마라.
* 메소드의 크기가 최대 **10라인**을 넘지 않도록 구현한다.
   * 메소드가 한 가지 일만 하도록 최대한 작게 만들어라.
* **자바 코딩 컨벤션을 지키면서 프로그래밍한다.**

## 로직 
* -- main method --
* Menu 생성
* Menu.inputMonsterCount() 에서 경기에 참가 할 몬스터 수 입력
* Menu.inputMonsterInformation() 에서 몬스터 이름과 속성을 입력
* Menu.inputAttemptCount() 에서 시도 횟 수 입력
* Racing 생성 (Menu 에서 입력받은 값) 
* Racing.createMonster() 에서 참가할 Monster들을 생성
* Racing.runRacing() 에서 경기 진행
* Menu.showResult() 에서 결과 출력
* Menu.showWinner() 에서 우승자 출력


## Step2 구현하기
* Menu class : 사용자 입력을 받는 클래스
* Racing class : 경기를 진행 하는 클래스
* Monster class : 경기를 참가 하는 클래스

    * Menu class
        * inputMonsterCount() : 참가 할 몬스터의 수 입력 메소드
        * inputAttemptCOunt() : 게임 시도 횟수 입력 메소드
        * showResult() : 결과 출력 메소드
    * Racing class
        * createMonster() : Menu에서 입력받은 참가 할 몬스터 숫자만큼 Monster 생성 메소드
        * runRacing() : 각각의 Monster들의 이동거리를 계산 해 Monster 자신의 이동거리 변수에 저장 하는 메소드, 경기 진행 하는 메소드
        * endRacing() : 각각의 Monster들이 가지고 있는 이동거리를 경기 결과 배열에 담아 리턴 하는 메소드, 경기 종료 메소드
    * Monster class
        * runMonster() : 몬스터 총 이동거리 저장 메소드
        * judgeRandomNumber() : 랜덤값 판단 후 boolean 리턴
        * countMonsterStep() : 1회당 이동 할 몬스터의 이동거리 메소드

## Step3 구현하기
* Monster class와 MoveInterface를 상속받는 Run, Fly, Esper class 생성
* Racing class에서 참여할 몬스터 수 만큼 Monster[] 배열을 만들고,
입력받은 monster 속성을 초이스 해서 각각의 monster를 만든다.
* 초이스 하기위해 enum MonsterAttribute를 만들었다.
* MonsterAttribute에 각각의 속성을 가지고 있다.
몬스터들이 경기 시도(Random)를 계산하는 함수를 여기로 옴겼다.
* Menu부분에서 사용자 입력을 받을 때, 발생할 수 있는 예외들을 처리하는 로직을 추가했다.
* Menu class에 showWinner() 메소드를 만들었다. 
* calculateRank()는 각각의 몬스터들이 가지고있는 stepCount를 이용해 승자를 계산하는 메소드다.
    * Ranking 계산은 참여한 몬스터 수 만큼 rank array를 만든다. 
    * rank array는 각 몬스터들의 랭킹을 담는 배열이다.
    * 먼저 모든 랭킹을 1로 초기화 한다.
    * for loop를 돌며 몬스터들의 stepCount를 비교하여 랭킹을 하나씩 늘려 나간다.
    * showWinner()에서 랭킹1등을 출력한다. (랭킹1등은 여러명일 수 있다)
## Class UML

![image](https://user-images.githubusercontent.com/53131108/74213941-c3398980-4cde-11ea-859b-8b2cbb916b99.png)




