# 각 단계별 코드 설계

## #step1

+ Monster.java
    
    - int trace : 현재까지 전진한 길이
    
    - update() : 매 회 랜덤값 도출, 40% 확률로 전진
    
    - print() : 매회 누적된 전진 길이(trace) 출력
    
    > 몬스터의 종류가 다양해지면 Monster.class는 추상 클래스나 인터페이스가 될 
    

+ MonsterRace.java

    - int rounds : 총 시도할 횟수

    - List<Monster> : 출전할 몬스터들을 저장하는 컬렉션
    
        ArrayList로 구현 (추후에 다른 컬렉션으로 변경될지도?)
        
    - readyRace() : 경주 시작 전, 필요한 정보를 입력받음
    
        - 경주에 출전할 몬스터 마리 수 (List<Monster>의 사이즈)
        
        - 시도할 횟수 (int rounds)
        
    - startRace() : 경주 시작. 회마다 updateRace 호
    
        - rounds 수만큼 업데이트를 반

    - updateRace() : List에 저장된 몬스터를 순회하면서 update, print를 호출
    