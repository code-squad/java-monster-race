package com.beemiel.monsterrace;

public class Psychic extends Monster {

    public Psychic(String type){
        super(type,9);
    }

    @Override
    public void moveOrStop() {
        if(isMove()){
            totalMove = moveByRandom();
        }
    }

    public String moveByRandom(){
        int randomMove = random.nextInt(100)+1;
        stringBuffer = new StringBuffer(totalMove);

        for(int i=0; i<randomMove; i++){
            stringBuffer.append("▷");
        }

        return stringBuffer.toString();
    }

}
