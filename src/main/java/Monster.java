public class Monster {

    private int traces;
    private static final int RANDOM_MAX = 10;
    private static final int FOWARD_PERCENTAGE = 4;

    public void update() {
        if(isForward())
            traces++;
    }

    public void render() {
        System.out.println(getTraces());
    }

    private boolean isForward() {
        int randomNumber = (int)(Math.random() * RANDOM_MAX);
        return (randomNumber >= FOWARD_PERCENTAGE);
    }

    private StringBuilder getTraces() {
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < this.traces; ++i){
            buffer.append("-");
        }
        return buffer;
    }
}
