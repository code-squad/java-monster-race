public class Monster {
    private int position;

    public Monster() {
        this.position = 0;
    }

    public int move(int position) {
        this.position += position;
        return this.position;
    }

    public int position() {
        return this.position;
    }
}
