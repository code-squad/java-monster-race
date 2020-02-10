public class Monster {
    private String name;
    private String type;
    private int moves;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String Name() {
        return this.name;
    }

    public String Type() {
        return this.type;
    }

    public int Moves() { return this.moves; }

    public void addMoves(int number) {
        this.moves += number;
    }
}