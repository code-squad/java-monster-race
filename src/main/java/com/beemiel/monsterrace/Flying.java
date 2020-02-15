package com.beemiel.monsterrace;

public class Flying extends Monster {

    public Flying(String type, String name){
        super(type,name);
        super.isRunNumber = RUN_NUMBER_OF_FLYING;
    }

    @Override
    public void moveOrStop() {
        if(isMove()){
            stringBuffer = new StringBuffer(totalMove);
            stringBuffer.append("▷▷▷");
            totalMove = stringBuffer.toString();
        }
    }

}
