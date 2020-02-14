# step3

- 클래스 구조

![클래스 구조1](https://i.imgur.com/wHEwWLg.png)

![클래스 구조2](https://i.imgur.com/nuYniE0.png)

- 요구사항에 따른 추가 사항 및 변경 사항

1. 비행,달리기,에스퍼 세 타입의 클래스를 추가하고 기존의 Moster클래스를 추상클래스로 만들어서 상속받음. 
2. enum을 사용하여 입력받은 타입을 검사하고 타입에 맞는 객체를 생성해줌.
3. 모든 라운드가 종료된 후 최종 우승자를 계산한 후 출력



- 클래스 상세
  - Monster Class
    - static final int RUN_NUMBER_OF_RUNNING - 달리기 타입 몬스터의 움직임을 결정하는 기준점
    - static final int RUN_NUMBER_OF_FLYING - 비행타입 몬스터의 움직임을 결정하는 기준점
    - static final int RUN_NUMBER_OF_ESPER - 에스퍼타입 몬스터의 움직임을 결정하는 기준점
    - String name - 몬스터의 이름
    - String type - 몬스터의 타입
    - int isRunNumber - 난수가 true인 조건
    - String totalMove - 총 걸음 수
    - Random random - random 재활용
    - StringBuffer stringBuffer - 문자열 추가
    - getName() - 몬스터의 이름 반환
    - setName(String name) - 몬스터의 이름 저장
    - isMove() -  isRunNumber 보다 크거나 같을 경우 true 반환
    - moveOrStop() - 추상메소드
    - run(int count) - 입력받은 카운트 수만큼 반복
    - toString() - 몬스터의 이름,타입,총 걸음 수 출력
  - Running Class
    - moveOrStop() - isMove()의 값이 true일 경우 1 추가
  - Flying Class
    - moveOrStop() - isMove()의 값이 true일 경우 3 추가
  - Psychic Class
    - moveByRandom() - 움직임 수를 난수로 생성 후 반환
    - moveOrStop() - isMove()의 값이 true일 경우 moveByRandom()만큼 추가
  - Message Class
    - 사용자에게 출력할 상수 문자열들의 집합
  - Race Class
    - ArrayList<Monster> monsters - 입력받은 몬스터 리스트
    - racing() - 레이스 정보를 입력받고 순차적으로 경기를 실행한 후 결과를 출력
    - startRacing(int count) - 카운트만큼 경기를 실행
  - Input Class 
    - Scanner scanner - 사용자에게 입력을 받기 위한 스캐너
    - inputMonster() - 몬스터 수 입력
    - inputMonsterInfo() - 몬스터 정보 입력, 그 정보로 생성된 객체 반환
    - inputCount() - 라운드 수 입력
    - close() - scanner 닫음 
  - MonsterType enum
    - 세 가지 타입 정의
    - findTypeByInput() - 입력한 타입이 존재하는지 확인
    - makeMonsterByType() - 각 타입마다 다른 객체를 생성해서 반환
  - Result Class
    - contenOfGame() - 콘솔에 경기 내용 출력
    - resultOfGame() - 콘솔에 경기 결과 출력 
    - appendString(ArrayList<Monster> winners) - 우승자 리스트에 있는 우승자들의 이름을 하나의 문자열로 반환
  - Calculator Class
    - ArrayList<Monster> winnerMonsters - 우승자 리스트
    - calculateResults() - calculateHigjhRecord()와 addWinnerMonster()를 실행한 후 우승자 리스트 반환
    - calculateHigjhRecord() - 최고점수 계산
    -  addWinnerMonster() - 최고점수와 같으면 우승자 리스트에 추가
  - Setting Class
    - int monster - 몬스터의 수
    - int count - 시도 횟수
    - Input input - 입력받는 객체
    - ArrayList<Monster> monsters - 입력받은 몬스터 리스트
    - getCount() - 시도 횟수 반환
    - getMonsters() - 몬스터 리스트 반환
    - setRace() - 레이스를 위한 사전 정보 입력 메서드들을 실행
    - setMonsterNumber() - 몬스터 객체의 수를 받음
    - setCOunt() - 시도 횟수를 받음
    - StringToInt() - 문자열을 int형으로 변환
    - setMonster() - 몬스터 변수의 수만큼 몬스터를 만듦
    - makeMonster() - 몬스터 정보를 입력받아서 몬스터 객체를 생성한 후 몬스터 리스트에 추가
    - checkInputFormat() - 입력값의 포맷을 확인
    - addMonster() - 몬스터 리스트에 몬스터 객체 추가
    - checkType() - 입력값의 타입을 체크
    - gameClose() - 스캐너 닫음



# step2  

step1에서 피드백 받은 내용들과 lucas의 요구 사항들을 통해 코드 수정

Input class 추가 - 사용자의 입력을 받는 부분을 분리

Output class 추가 - 콘솔에 출력하는 부분을 분리

Message class 추가 - 변하지 않는 문자열을 모아둠

Main, Monster, Race class 수정 - 기존의 클래스에서 입력과 출력을 하는 부분들을 Input과 Output으로 대체



