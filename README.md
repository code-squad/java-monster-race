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
* Menu 실행
* Menu 에서 몬스터 수와 게임 시도 수 입력
* Racing 생성 (Menu 에서 입력받은 값) 
* Racing 에서 참가할 Monster들을 생성
* Racing 에서 경기 진행
*  Menu 에서 결과 실행


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

## Class UML

![image](https://user-images.githubusercontent.com/53131108/73823489-b8dd4280-483b-11ea-85ac-00c38892f8b9.png)



