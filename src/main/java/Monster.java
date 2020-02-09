public class Monster {
    private String name;
    private String type;
    private int moves;

    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getMoves() { return this.moves; }

    public void addMoves() { this.moves++; }
}