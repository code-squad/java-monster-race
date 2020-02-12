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

## Step 2

#### 설계

- Race

경기 규칙을 설정하는 책임이 있다. (Rule 객체에게 위임)
참가자를 등록하는 책임이 있다. (Reception 객체에게 위임)
경기를 수행하는 책임이 있다.
경기 내용을 보여주는 책임이 있다. (Dashboard 객체에게 위임)

- Rule

경기의 규칙을 설정하는 책임이 있다.

- Reception

게임에 참가할 몬스터들을 관리하는 책임이 있다.

- Monster

움직이는 책임이 있다. (Movable 인터페이스에 위임)

- CommandInterface

사용자로부터 유효한 입력을 얻는 책임이 있다.

- Dashboard

경기 정보를 출력하는 책임이 있다.
