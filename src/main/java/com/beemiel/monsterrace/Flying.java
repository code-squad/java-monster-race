package com.beemiel.monsterrace;

public class Flying extends Monster {

    public Flying(String name, String type) {
        super(name, type);
    }

    @Override
    public boolean isMove() {
        return random.nextInt(10) > 5;
    }

    @Override
    public void moveOrStop() {
        if(isMove()){
            stringBuffer.append(totalMove);
            stringBuffer.append("▷▷▷");
            totalMove = stringBuffer.toString();
        }
    }

//    @Override
//    public void run(int count) {
//
//    }
}