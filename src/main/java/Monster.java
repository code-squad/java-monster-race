public class Monster {

    private int traces;

    public void update(){
        boolean isForward = (int) (Math.random() * 10) >= 4;

        if(isForward)
            traces++;
    }

    public void print(){
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < this.traces; ++i){
            buffer.append("-");
        }
        System.out.println(buffer);
    }
}
