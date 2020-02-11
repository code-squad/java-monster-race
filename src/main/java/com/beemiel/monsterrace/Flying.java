package com.beemiel.monsterrace;

public class Flying extends Monster {

    public Flying(String type){
        super(type,6);
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
