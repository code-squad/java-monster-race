public class Monster {

    private int traces;
    private boolean isForward;

    public void update(){
        boolean isForward = (int)(Math.random() * 10) >= 4 ? true : false;

        if(isForward)
            traces++;
    }

    public void print(){
        for(int i = 0; i < this.traces; ++i){
            System.out.print("-");
        }
        System.out.println();
    }
}
