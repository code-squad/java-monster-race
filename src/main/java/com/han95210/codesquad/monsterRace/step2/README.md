## 몬스터 경주 2단계 요구사항
---
### 기능 요구사항
---
* 1단계와 같다.

### 프로그래밍 요구사항
---
* indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* else를 사용하지 마라.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* 메소드가 한 가지 일만 하도록 최대한 작게 만들어라.
* stream은 가능하면 사용하지 않는다.
* **자바 코딩 컨벤션을 지키면서 프로그래밍한다.**

## 자바 코딩 컨벤션
---
### 클래스 구현 순서
* 클래스의 구현 순서는 다음과 같다. 다음 원칙에 따라 구현한다.
```
class A {
    //상수(static final) 또는 클래스 변수
    //인스턴스 변수
    //생성자
    //메서드
}
```

### Naming Convention
* 자바는 낙타 표기법(Camel Case)를 따른다.
* 패키지명은 소문자만 허용
* 클래스명은 대문자로 시작, 변수 메서드는 소문자로 시작
* 클래스 이름 예 : Rectangle, LaundryList, StudentDirectory
* 변수 이름 예 : firstName, description, mediaController
* 메서드 이름 예 : getFirstName(), cancelOrder(), isDeleted()

### 들여쓰기, 공백 등
* 들여쓰기, 공백과 같은 규칙은 IntelliJ의 formatting 기능을 활용한다.
* 단축키로 맥은 Alt + Cmd + L, 윈도우즈는 Ctrl + Shift + Alt + L을 실행하면 된다.

### 참고 문서
* 더 자세한 규칙은 [자바 코딩 규칙](http://kwangshin.pe.kr/blog/java-code-conventions-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9-%EA%B7%9C%EC%B9%99/) 문서 또는 구글에서 **자바 코딩 컨벤션**으로 검색해 방법을 찾아본다.

## 힌트
---
* indent(들여쓰기)를 줄이는 가장 좋은 방법은 메서드를 분리하는 것이다.
    <br>* indent가 2이상인 메서드의 경우 메서드를 분리하는 방법을 찾는다.
    <br>* 메서드 라인이 10라인을 넘어가는 경우 메서드를 분리한다.
* else를 사용하지 않는 방법은 if절에서 값을 바로 return하면 메서드 실행이 종료되기 때문에 가능하다.
```
public int add(String text) {
    int result;
    if (text == null || text.isEmpty()) {
        result = 0;
    } else {
        result = Integer.parseInt(text);
    }

    return result;
}
```
* 위 코드는 다음과 같이 else를 사용하지 않고 구현 가능하다.
```
public int add(String text) {
    if (text == null || text.isEmpty()) {
        return 0;
    }

    return Integer.parseInt(text);
}
```