# step1

### 설계도

**MonsterRace 클래스**

* monsterCnt : 경주할 몬스터 마릿수

* attemptCnt : 시도 횟수



**Monster 클래스**

몬스터 객체는 각자 구분가능한 id 값과 해당 회차에 앞으로 전진할 이동 횟수 값을 가진다.

* id - 몬스터 구분

* forwardCount - 전진 횟수 : random값 4이상으로
* toString() : overriding 전진 상태를 String으로 return

* setRandomCount() : 전진 횟수를 random으로 뽑아서 forwardCount에 합산



---

# step2

1. 변수 및 메소드명 수정

- setRandomCount() -> run()

* monsterCnt ->  monsterCount
* attemptCun -> attemptCount



2. 메서드가 한 가지 일만 하도록 분리

**MonsterRace 클래스**

* mosters 리스트와 monsterCount, attemptCount 변수를 클래스의 멤버 변수로 변경
* main() : MonsterRace 객체 생성 후, 전체적인 경기 흐름 동작
* inputInfo() : 사용자로부터 경기에 필요한 정보를 입력받는다.
* addMonster() : 몬스터 객체를 생성해서 mosters 리스트에 추가
* play() : 경기 진행. 시도 횟수만큼 몬스터들이 run()



3. **Scanner 입력 시, 숫자 외 입력값에 대한 에러처리 추가**

`InputMismatchException` 에러 발생 시, 안내문구 출력 후, 재귀호출을 통해 재입력을 받는다.

```java
 public void inputInfo() {
        try {
            Scanner sc = new Scanner(System.in);
            String promptMonster = "몬스터는 모두 몇 마리인가요?";
            String promptAttempt = "시도할 회수는 몇 회 인가요?";

            System.out.println(promptMonster);
            monsterCount = sc.nextInt();
            System.out.println(promptAttempt);
            attemptCount = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            this.inputInfo();
        }
    }
}
```



4. scanner 오픈, 종료 기능을 메서드로 분리하여 추가, 입력메서드를 nextInt() -> nextLine() 으로 변경

사용을 다한 Scaaner을 close()를 통해 안정적으로 종료시켜 주는 것이 좋다고 하여, 프로그램 종료 전 스트림을 닫아주는 terminate() 메서드를 추가함
그 과정에서 scanner.nextInt() 로 사용자의 입력값을 정수로 받았는데, 에러가 발생할 경우 다시 입력을 받도록 재귀호출을 하는 과정에서 스트림에 남아있는 개행문자("\n")가 남아있어서 무한으로 호출이 되어 StackOverflow 가 발생하면서 프로그램이 죽음.
(nextInt() 메서드는 사용자의 입력값을 받아 내부적으로 개행문자이전의 숫자값만 추출해서 개행문자가 그대로 남아있다고 한다.)
그래서 scanner.nextLine() 으로 입력받도록 수정하고, NumberFormatException 에러를 받아서 처리하도록 수정함

```java
    public void inputInfo() {
        try {
            String promptMonster = "몬스터는 모두 몇 마리인가요?";
            String promptAttempt = "시도할 회수는 몇 회 인가요?";

            System.out.println(promptMonster);
            monsterCount = Integer.parseInt(scanner.nextLine());
            System.out.println(promptAttempt);
            attemptCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputInfo();
        }
    }
```



5. 사용자로부터 입력받는 메서드를 각 정보별로 따로 입력받도록 메서드 분리

   inputInfo() 에서 한번에 몬스터 마릿수와 시도 횟수를 입력받았는데, inputMonsterInfo() 와 inputAttemptInfo() 메서드로 분리
   각 메서드에서 입력값에 대한 검증을 하도록 구현
   inputMonsterInfo() : 몬스터 마릿수를 입력받는 메서드
   inputAttemptInfo() : 시도 횟수를 입력받는 메서드

```java
public void inputInfo() {
        inputMonsterInfo();
        inputAttemptInfo();
    }

    public void inputMonsterInfo() {
        try {
            String promptMonster = "몬스터는 모두 몇 마리인가요?";

            System.out.println(promptMonster);
            monsterCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputMonsterInfo();
        }
    }

    public void inputAttemptInfo() {
        try {
            String promptMonster = "시도할 회수는 몇 회 인가요?";

            System.out.println(promptMonster);
            attemptCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력하실 수 있습니다. 다시 입력해주세요.");
            inputAttemptInfo();
        }
    }
```



- [x] 사용 완료한 Scanner 닫아주는 구문 추가
- [x] 사용자 입력 받는 메서드 입력 정보에 따라 분리

---

# Refactoring

- [x] 코멘트 내용으로 코드 수정

  - [x] 접근 한정자는 private을 기본으로 생각해 주세요.

  - [x] ready()는 없애고 생성자에 넣는게 좋지 않을까요?

  - [x] input 메소드들에 코드의 중복이 있습니다. 제거 시도해 보세요.

    `inputMonsterInfo()`와 `inputAttemptInfo()`에 입력값 검증을 위한 예외처리부분이 중복되어 있어서 `inputProperType()`에서 입력값을 검증 후 반환해주도록 따로 분리

  - [x] input 기능을 담당하는 별도의 클래스로 분리 : `InputHandler.java`

  - [x] Monter.id는 그다지 필요 없는 것 같습니다.

- [x] MonsterRace의 인스턴스 변수의 초기화를 선언과 분리 -> MonsterRace 생성자에서 초기화해주도록 수정

- [x] 사용자 입력 값 검증 추가 : 음의 정수 입력 시 재입력 받도록 수정

- [x] 기존 play() 메소드명을 run()으로 수정

- [x] public 접근자인 main 메서드안에서 순서를 가진 메서드 호출문을 가지는 것이 안좋으므로 main 에서 순서대로 호출했던 프로그램의 흐름을 private void play(){} 과 같이 새로운 메서드로 구현하여, main에서는 play()을 호출만 하도록 해준다.

---

# step3

**[설계도]**

* Monster 를 추상클래스로 변경하여 Runner, Flight, Espurr 가 상속받는다.
* 몬스터는 MonsterType(Enum)에 존재하는 type이여야 생성 가능하다.

- setForwardCount메서드 오버라이딩 - 각 자식클래스는 타입별로 한번에 전진 가능한 칸 수를 셋팅한다.
  

![image-20200210031601905](https://tva1.sinaimg.cn/large/0082zybpgy1gbqpaj8sytj31jn0u0n37.jpg)

##### Monster 클래스

* monsterType : Monster 클래스가 가질 수 있는 종류 
* minCriteria : 전진가능한 최소 랜던값 기준
* fowardCount : 한 번에 전진 가능한 칸 수
* forwardPosition : 전진 위치 상태
* setForwardCount() : (abstract) 각 몬스터마다 fowardCount를 설정해준다. (Espurr는 move()할때마다 바뀜)

* move() : fowardCount만큼 앞으로 전진
* isAboveMinCriteria() : 랜덤값이 minCriteria(전진가능한 최소 랜던값 기준)이상 인지 체크
* toString() : 자신의 정보를 문자열로 반환 
  * 형식 : **"이름(monsterName) [타입(monsterType)] :  전진위치(forwardPosition)"**
  * ex) `하니 [달리기] : ----`



##### MonsterType Enum

* Monster 클래스가 가질 수 있는 타입에 대한 Enum
  * monsterType : Monster 클래스가 가질 수 있는 종류 
  * minCriteria : 전진가능한 최소 랜던값 기준
* valueOfType() : 입력한 monsterType이 MonsterType의 type과 같으면 MonsterType을 넘겨주고, 없다면 에러를 던져줌



##### InputHandler 클래스

* inputMonsterInfo() : 경주할 몬스터 이름과 종류를 입력받는 기능 구현
  * 입력 문자열의 공백을 제거 후, (콤마)를 delimiter(구분자)로하여 문자열배열로 반환
  * 형식에 맞지 않을 시 에러처리



**MonsterRace 클래스**

* createMonster() : 몬스터 정보를 입력받아 해당하는 타입의 Monster 생성
  * 몬스터 정보를 잘못 입력 시 재입력 받도록 에러 처리

* printWinner() : 우승자 이름 출력
* pickWinner() : 우승자 선정

