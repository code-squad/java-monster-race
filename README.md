# java-monster-race

코드스쿼드 백엔드 자바 학습 프로젝트 1

## 구현하기

- lucas의 요구사항 문서를 참고해서 구현한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.

## PR 보내는 법

- 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
- 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

- [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)
- [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtu.be/a5c9ku-_fok)



---

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

`InputMismatchException` 에러 발생 시, 안내문구 출력 후, 재입력을 받는다.



---

