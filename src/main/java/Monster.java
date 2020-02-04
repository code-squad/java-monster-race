import java.util.Random;

public class Monster {
    private int count;

    public Monster(int count) {
        this.count = count;
    }

    private boolean getRandom(){
        Random random = new Random();
        return random.nextInt(10) > 4;
    }

    public void run(){
        while (this.count>0){
            if(getRandom()){
                System.out.print("-");
            }
            this.count--;
        }
        System.out.println("");
    }
}
