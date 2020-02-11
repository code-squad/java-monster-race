# step3

- 클래스 구조

![클래스 구조](https://i.imgur.com/kQt0kpL.png)

- 요구사항에 따른 추가 사항 및 변경 사항

1. 비행,달리기,에스퍼 세 타입의 클래스를 추가하고 기존의 Moster클래스를 추상클래스로 만들어서 상속받음. 
2. enum을 사용하여 입력받은 타입을 검사하고 타입에 맞는 객체를 생성해줌.
3. 모든 라운드가 종료된 후 최종 우승자를 계산한 후 출력



- 클래스 상세
  - Monster Class
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
    - 사용자에게 안내할 콘솔 출력문 모음
  - Race Class
    - int monster - 몬스터의 수
    - int count - 라운드 수
    - ArrayList<Monster> monsters - 입력받은 몬스터 리스트
    - ArrayList<Monster> winnerMonsters - 우승한 몬스터 리스트
    - Message message - 콘솔에 메세지 출력
    - Input input - 사용자로부터 입력을 받음
    - Output output - 사용자에게 경기 결과 출력
    - racing() - 순차적으로 경기 실행
    - setting() - 경기 시작 전 몬스터 수, 라운드 수, 몬스터 정보를 세팅
    - makeMonster() - 몬스터 객체를 얻어 몬스터 리스트에 추가
    - calculateResults() - 최종 결과 연산 calculateHighRecod() 와 addWinnerMonster()  호출
    - addWinnerMonster() - 최고점과 같으면 우승자 리스트에 추가
    - calculateHighRecod() - 최고 점수 계산
  - Input Class 
    - Scanner scanner - 사용자에게 입력을 받기 위한 스캐너
    - Message message - 콘솔에 안내 문구 출력
    - inputMonster() - 몬스터 수 입력
    - inputMonsterInfo() - 몬스터 정보 입력, 그 정보로 생성된 객체 반환
    - inputCount() - 라운드 수 입력
    - close() - scanner 닫음 
  - MonsterType enum
    - 세 가지 타입 정의
    - getMonster() - monster 반환
  - Output Class
    - Message message - 안내 문구 출력
    - contenOfGame() - 콘솔에 경기 내용 출력
    - resultOfGame() - 콘솔에 경기 결과 출력 



# step2  

step1에서 피드백 받은 내용들과 lucas의 요구 사항들을 통해 코드 수정

Input class 추가 - 사용자의 입력을 받는 부분을 분리

Output class 추가 - 콘솔에 출력하는 부분을 분리

Message class 추가 - 변하지 않는 문자열을 모아둠

Main, Monster, Race class 수정 - 기존의 클래스에서 입력과 출력을 하는 부분들을 Input과 Output으로 대체



