package com.beemiel.monsterrace;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Setting {
    //이거도 두개로 줄이고 싶은데
    private int monster;
    private int count;
    private Input input;
    private ArrayList<Monster> monsters = new ArrayList<>();

    public Setting() {
        this.input = new Input();
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setRace() {
        System.out.println(Message.TITLE);
        setMonsterNumber();
        setMonster();
        setCount();
    }

    public void setMonsterNumber() {
        try{
            System.out.println(Message.MONSTER_NUMBER);
            this.monster = StringToInt(input.inputMonster());
        } catch (NumberFormatException n) {
            System.out.println(Message.EXCEPTION_OF_NUMBER);
            setMonsterNumber();
        }
    }

    public void setCount() {
        try{
            System.out.println(Message.TRY);
            this.count = StringToInt(input.inputCount());
        } catch (NumberFormatException n) {
            System.out.println(Message.EXCEPTION_OF_NUMBER);
            setCount();
        }
    }

    public int StringToInt(String str) throws NumberFormatException{
            return Integer.parseInt(str);
    }

    public void setMonster() {
        makeMonster();
        this.monster--;
        if(monster > 0){
            setMonster();
        }
    }

    public void makeMonster() {
        try{
            System.out.println(Message.MONSTER_INFO);
            String[] infos = checkInputFormat(input.inputMonsterInfo()).split(",");
            MonsterType monsterType = checkType(infos[1]);
            addMonster(monsterType.makeMonsterByType(infos[0]));
            System.out.println(infos[1]+"타입 생성");

        } catch (NullPointerException n) {
            System.out.println(Message.EXCEPTION_OF_NULL);
            makeMonster();

        } catch (NoSuchElementException n) {
            System.out.println(Message.EXCEPTION_OF_NOT_FOUND_TYPE);
            makeMonster();

        }
    }

    public String checkInputFormat(String info) {
        if(Pattern.matches("[a-z A-Z 0-9 ㄱ-ㅎ 가-힣]+\\,[a-z A-Z 0-9 ㄱ-ㅎ 가-힣]+",info)){
            return info;
        }
        return null;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public MonsterType checkType(String type) throws NoSuchElementException {
            return MonsterType.findTypeByInput(type);
    }

    public void gameClose() {
        input.close();
    }

}
