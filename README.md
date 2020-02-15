### 몬스터 레이스 5단계 구현하기
#### 요구사항
이 단계는 클래스 전체 구조에 대한 힌트와 피드백을 제공하는 단계이다.
이 단계의 피드백을 통해 반영할 부분이 있는지 파악해 반영할 부분이 있다면 자신의 코드를 개선한다.
> MVC
>
기본 패턴으로 MVC 패턴(Model View Controller) 구조를 유지하면서 구현하면 큰 틀에서의 분리가 가능함.

> 전체 클래스 구조 힌트

사용자에게 값을 입력 받는 코드, 값을 출력하는 코드와 같이 UI 로직을 담당하는 코드와 핵심 로직을 구현하는 코드를 별도의 클래스로 분리한다.
```java
public class RacingMain {
    public static void main(String[] args) {
        String monsterNames = InputView.getMonsterNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(monsterNames);
        racingGame.racing(tryNo);

        ResultView.printResult(racingGame);
    }
}

public class RacingGame {
    private Monster[] monsters;
    //implement
}

public class Monster {
    private String name;
    private int position = 0;
    //implement
}
```

> 코딩 컨벤션 피드백

1. 이름 짓기
    - package 이름은 소문자만 사용한다.
    - class 이름은 대문자로 시작하고, 단어가 구분되는 경우 대문자로 시작한다(camel convention).
    - method 이름은 소문자로 시작하고, 단어가 구분되는 경우 대문자로 시작한다(camel convention).
    - class 이름은 명사, method 이름은 동사로 시작한다.
2. 공백 라인을 의미있게 사용해라. 문맥을 분리하는 부분에 사용한다
    - 불필요한 공백 라인을 추가하지 않는다. 공백 라인 또한 의미를 가지기 때문에 코드에서 문맥상 다른 의미를 가지는 경우만 사용한다.
3. 상수 값의 경우 static final, 변수 이름은 대문자
    ```java
    private static int RANGE = 9;
    private final int MIN_COUNT = 1;
    ````
4. space도 고려한다
    ```java
    for (int i=10; i<1000; i++) {
        assertTrue(checkMove(2, i));
        assertTrue(checkMove(20, i));
        assertTrue(checkMove(200, i));
    }
    ```

5. 인스턴스 변수는 특별한 경우가 아니면 private을 사용하자
    ```java
    public class Monster {
        String name;
        int position = 0;
    }
    ```

### 전 단계 피드백
- 필드가 동일하다고 해서 중복 줄이기위해서 하나의 클래스로 모으지 않아도 됩니다.
  중복 줄이기 보다는 객체의 상태값 임의 변경이 가능하여 부작용 발생하는 것에 초점을 맞춰보셨으면 좋겠습니다.
  
- [x] 입력 받은 값으로 몬스터 타입 매칭해주는 역할을 클래스 분리
    - controller에 매칭을 두고 입출력을 클래스 분리 
- [ ] 메소드도 1가지 일만 할 수 있도록 분리
    - 아직 덜 된 거 같다
- [x] interface 사용 연습
    - monster를 interface로 변경