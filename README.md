## 구조

### Class

- RacingGame : 게임 전반에 대한 설정 정보를 담고, 결과를 출력하는 클래스
- Monster : 몬스터 클래스
- GameMachine : 게임의 로직을 진행하는 main 메서드가 담겨 있는 클래스

### RacingGame

- numOfMonsters : 생성할 몬스터의 수
- numOfTries : 시도 횟수
- Monster[] monsters : 생성한 몬스터 객체를 저장하는 배열
- createMonsters() : 입력 받은 수만큼 monster 객체를 생성하여 배열에 저장하는 메서드
- startGame() : 주어진 시도 횟수를 기반으로 게임을 실행한다.
- getNumOfMonster() : 생성할 몬스터의 수를 유저로부터 입력 받는 메서드
- getNumOfTries() : 시도할 횟수를 유저로부터 입력 받는 메서드
- printResult() : 게임 결과를 출력하는 메서드

### Monster

- moveCount : 몬스터가 움직일 횟수
- decideMoveOrStop() : 생성한 랜덤수를 바탕으로 Move와 Stop 여부를 결정하는 메서드
- move() : decideMoveOrStop()에서 받은 결과를 바탕으로 move일 때 moveCount 변수를 증가 시킨다.
- run() : 인자로 전달 받은 시도 횟수만큼 순회하며 몬스터의 이동 횟수를 결정한다.
- toString() : 몬스터의 움직임 횟수를 출력하는 메서드

### GameMachine

- main메서드가 담겨 있는 클래스
- RacingGame 객체를 생성하여 로직을 실행한다.

## 실행순서

1. 게임에 대한 모든 정보를 담고 있는 RacingGame 객체를 생성한다.
2. 생성한 RacingGame 객체를 통해 몬스터의 수와 시도 횟수를 유저 입력으로 받는 메서드를 호출 한다.
3. RacingGame 객체에저장 되어 있는 몬스터의 수를 바탕으로 몬스터를 생성하여 배열에 담는다.
4. 게임을 시작시킨다. 실행 순서는 다음과 같다.
   1. RacingGame 객체에 저장된 시도 횟수를 인자로 하여 각 monster객체의 run()을 호출한다.
   2. 각 monster 객체마다 decideMoveOrStop() 메서드를 호출하고, 반환 결과를 바탕으로 move() 메서드를 실행한다.
5. 저장된 이동 횟수를 바탕으로 결과를 출력한다.
