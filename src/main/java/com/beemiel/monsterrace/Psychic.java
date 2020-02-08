package com.beemiel.monsterrace;

public class Psychic extends Monster {

    public Psychic(String name, String type) {
        super(name, type);
    }

    @Override
    public boolean isMove() {
        return random.nextInt(10) > 8;
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
