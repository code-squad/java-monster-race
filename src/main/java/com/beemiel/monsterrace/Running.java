package com.beemiel.monsterrace;

public class Running extends Monster {

    public Running(String type, String name){
        super(type,name);
        super.isRunNumber = RUN_NUMBER_OF_RUNNING;
    }

    @Override
    public void moveOrStop() {
        if(isMove()){
            stringBuffer = new StringBuffer(totalMove);
            stringBuffer.append("▷");
            totalMove = stringBuffer.toString();
        }
    }

}
