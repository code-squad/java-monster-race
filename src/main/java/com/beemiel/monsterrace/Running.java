package com.beemiel.monsterrace;

public class Running extends Monster {

    public Running(String name, String type) {
        super(name, type);
    }

    @Override
    public boolean isMove() {
        return random.nextInt(10) > 3;
    }

    @Override
    public void moveOrStop() {
        if(isMove()){
            stringBuffer.append(totalMove);
            stringBuffer.append("▷");
            totalMove = stringBuffer.toString();
        }
    }

//    @Override
//    public void run(int count) {
//        for(int i=0; i<count; i++){
//            moveOrStop();
//        }
//    }
}
