## 구조

### Class

- RacingGame : 게임 전반에 대한 설정 정보를 담고, 결과를 출력하는 클래스
- InputHandler : 사용자의 입력을 담당하는 클래스
- Types : 몬스터의 타입이 정의되어 있는 열거형
- Monster : 몬스터 클래스 (추상 클래스)
- Runner : 달리기 타입 몬스터를 정의한 클래스
- Flying : 비행 타입 몬스터를 정의한 클래스
- Esper : 에스퍼 타입의 몬스터를 정의한 클래스
- GameMachine : 게임의 로직을 진행하는 main 메서드가 담겨 있는 클래스

### RacingGame

- inputHandler : 사용자 입력을 받는 객체를 생성
- numOfMonsters : 생성할 몬스터의 수
- numOfTries : 시도 횟수
- ArrayList<monster> monsters : 생성한 몬스터 객체를 저장하는 ArrayList
- ArrayList<monster> winners : 우승자 몬스터를 저장하는 ArrayList
- createMonster() : 전달받은 이름과 타입으로 몬스터를 생성한다.
- configureGameSettings() : 몬스터의 수, 이름과 종류, 시도횟수를 입력 받는 로직을 담은 메서드
- startGame() : 생성된 몬스터들을 순회하며 입력 받은 시도 횟수만큼 실행
- findMaxValue() : 각 몬스터들을 순회하며 moveCount의 최대값을 반환
- determineWinners() : 전달 받은 최대값과 각 몬스터의 moveCount 값이 같을 경우 winners에 추가
- finishGame() : 게임 결과를 출력하는 메서드, 각 몬스터의 moveCount 누적 값과 우승자 정보를 출력한다.

### Monster

- name : 몬스터의 이름
- type : 몬스터의 타입 (열거형)
- moveCount : 몬스터가 움직일 횟수
- rangeAbility : 이동거리를 지정
- isMove() : 생성한 랜덤수를 바탕으로 Move여부를 결정하는 메서드 (abstract)
- move() : isMove()에서 받은 결과를 바탕으로 moveCount 변수를 증가 시킨다. (abstract)
- run() : 인자로 전달 받은 시도 횟수만큼 순회하며 몬스터의 이동 횟수를 결정한다.
- toString() : 몬스터의 움직임 횟수를 출력하는 메서드

### Runner

- RUNNER_RANGE : 달리기 타입의 이동거리
- RUNNER_CRITERION : 달리기 타입의 move를 판정하는 기준치
- isMove() : 생성한 랜덤수를 바탕으로 Move여부를 결정하는 메서드
- move() : isMove()에서 받은 결과를 바탕으로 moveCount 변수를 증가 시킨다.

### Fyling

- FLYING_RANGE : 비행 타입의 이동거리
- FLYING_CRITERION : 비행 타입의 move를 판정하는 기준치
- isMove() : 생성한 랜덤수를 바탕으로 Move여부를 결정하는 메서드
- move() : isMove()에서 받은 결과를 바탕으로 moveCount 변수를 증가 시킨다.

### Esper

- esperRange : 에스퍼 타입의 이동거리
- ESPER_CRITERION : 에스퍼 타입의 move를 판정하는 기준치
- isMove() : 생성한 랜덤수를 바탕으로 Move여부를 결정하는 메서드
- move() : isMove()에서 받은 결과를 바탕으로 moveCount 변수를 증가 시킨다.

### GameMachine

- main메서드가 담겨 있는 클래스
- RacingGame 객체를 생성하여 로직을 실행한다.

## 실행순서

1. 게임에 대한 모든 정보를 담고 있는 RacingGame 객체를 생성한다.
2. RacingGame 객체에서 InputHandler 객체를 생성해서 몬스터의 수, 이름과 종류, 시도 횟수 입력 받는다.
3. RacingGame 객체에 저장 되어 있는 몬스터의 수를 바탕으로 몬스터를 생성하여 ArrayList에 담는다.
4. 게임을 시작시킨다. 실행 순서는 다음과 같다.
   1. RacingGame 객체에 저장된 시도 횟수를 인자로 하여 각 monster객체의 run()을 호출한다.
   2. 각 monster 객체마다 isMove() 메서드를 호출하고, 반환 결과를 바탕으로 move() 메서드를 실행한다.
   3. 저장된 이동 횟수를 바탕으로 결과를 출력한다.
