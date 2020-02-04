import java.util.Random;

public class Monster {

    private boolean getRandom(){
        Random random = new Random();
        return random.nextInt(10) > 4;
    }

    public void run(int count){
        while (count>0){
            if(getRandom()){
                System.out.print("-");
            }
            count--;
        }
        System.out.println("");
    }
}
