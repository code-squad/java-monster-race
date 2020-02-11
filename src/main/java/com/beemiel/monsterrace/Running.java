package com.beemiel.monsterrace;

public class Running extends Monster {

    public Running(String type){
        super(type,4);
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
