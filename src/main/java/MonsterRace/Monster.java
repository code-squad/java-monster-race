package MonsterRace;

// 달리기, 비행, 에스퍼
// 몬스터의 이동은 타입에 따라 달라진다. 달리기: 랜덤값이 4이상인 경우 1칸 이동, 비행: 랜덤값이 6이상인 경우 3칸 이동,
// 에스퍼: 랜덤값이 9인 경우 무작위 숫자 (1 < x < 100) 만큼 전진

public abstract class Monster {
    private String _name;
    private String _type;
    public int _distance;

    public Monster(String _name, String _type) {
        this._name = _name;
        this._type = _type;
        this._distance = 0;
    }

    /**
     * public abstract int getDistance(roundCount)
     * 몬스터의 타입에 따라 이동한 거리를 return 합니다.
     */
    public abstract int setDistance(int roundCount);

    @Override
    public String toString() {
        return this._name + " [" + this._type + "] : ";
    }

    public int getDistance() {
        return _distance;
    }
}

class RunMonster extends Monster {
    public RunMonster(String _name, String _type) {
        super(_name, _type);
    }

    @Override
    public int setDistance(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            double randomCount = Math.random() * 9;
            _distance += (randomCount >= 4) ? 1 : 0;
        }

        return _distance;
    }
}

class FlyMonster extends Monster {
    public FlyMonster(String _name, String _type) {
        super(_name, _type);
    }

    @Override
    public int setDistance(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            double randomCount = Math.random() * 9;
            _distance += (randomCount >= 6) ? 3 : 0;
        }

        return _distance;
    }
}


class EsperMonster extends Monster {
    public EsperMonster(String _name, String _type) {
        super(_name, _type);
    }

    @Override
    public int setDistance(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            double randomCount = Math.random() * 9;
            _distance += (randomCount >= 6) ? (Math.random() * 98) + 1 : 0;
        }

        return _distance;
    }
}