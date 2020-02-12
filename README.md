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
  
## step3
  
  + Monster 클래스 추상 클래스로 변경
  
    + 몬스터의 종류가 추가되었기 때문에 몬스터에게 공통적으로 필요한 요소를 정의하고 종류별로 update()의 구현 내용이 달라져야 함
    + 모든 몬스터의 공통적 요소
      + static final int RANDOM_MAX : 전진 확률 최대 범위
      + String name : 몬스터의 이름
      + TYPE : 몬스터 종류 (enum형)
      + int traces : 전진 거리
    + update() : 추상 메소드로 선언
  
    
  
    > 고민했던 것
  
    + Monster 클래스를 추상클래스로 구현 vs 인터페이스로 구현
  
      공통적으로 필요한 (멤버)변수가 몇가지 존재하므로 추상클래스를 선택함
  
      
  
  + 몬스터 종류별 자식 클래스
  
    + Normal.java
    + Flying.java
    + Psychic.java
  
    
  
  + Input 변경 사항
  
    + 입력받은 데이터를 몬스터 타입으로 파싱하는 기능 추가
  
  
  
  > 새롭게 추가된 것
  
  + TYPE.java
  
    + 몬스터의 종류를 정의한 enum 변수
    + 종류별 상수값도 함께 묶음 (typeName, speed, randomLimit)
    + 종류 : NORMAL(달리기), FLYING(비행), PSYCHIC(에스퍼)
  
    
  
  + MonsterFactory.java
    + 인자로 전달받은 데이터를 이용하여 그에 해당하는 몬스터 자식 객체를 반환