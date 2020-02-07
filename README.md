# 각 단계별 코드 설계

## step1

+ Monster.java

  - int trace : 현재까지 전진한 길이

  - update() : 매 회 랜덤값 도출, 40% 확률로 전진

  - print() : 매회 누적된 전진 길이(trace) 출력

  > 몬스터의 종류가 다양해지면 Monster.class는 추상 클래스나 인터페이스가 될 듯

+ MonsterRace.java

  - int rounds : 총 시도할 횟수

  - List\<Monster> : 출전할 몬스터들을 저장하는 컬렉션. ArrayList로 구현

  - readyRace() : 경주 시작 전, 필요한 정보를 입력받음

    - 경주에 출전할 몬스터 마리 수 (List<Monster>의 사이즈)

    - 시도할 횟수 (int rounds)

  - startRace() : 경주 시작. 회마다 updateRace 호

    - rounds 수만큼 업데이트를 반

  - updateRace() : List에 저장된 몬스터를 순회하면서 update, print를 호출

  

## step2

+ ConsoleIO.java

  - 게임에 필요한 입력과 출력을 담당하는 클래스 정의

  > 고민되는 점

  입출력을 담당하는 메소드를 구현할 때,

  + 여러 상황에서 재사용될 수 있는 메소드로 구현하는게 좋은지

  + 특정 상황에만 필요한 출력과 입력을 수행하는 메소드로 구현할지

  > 출력과 함께 정수를 입력받는 모든 상황에 사용할 수 있는 메소드
  >
  > 이점 : 재사용

  ```java
  static int inputInt(String line){
    System.out.println(line);
    return nextInt();
  }
  ```

  > 특정 상황에만 호출되는 메소드
  >
  > 이점 : 해당 메소드의 기능이 명확히 보임

  ```java
  static int getCountOfMonsters(){
  	System.out.println("몇 마리 몬스터?");
  	return nextInt();
  }
  ```

  

+ ConsoleIO.java => Input.java 로 변경

  + 현재 로직에서 입력과 출력을 구분하는 것이 어려워서 출력은 필요할 때마다 System.out.println()으로 출력하고, 사용자 입력 전용 클래스로 변경함.

  > 객체의 책임을 잘 구분하지 못하는 것 같다.



+ GameMachine.java
  + main 함수만 실행하는 클래스
  + (before) MonsterRace.java에 main 함수와 게임 로직이 함께 존재함 => (after) MonsterRace.java에는 게임 로직만 존재