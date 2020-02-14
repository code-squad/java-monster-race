public enum Table {
    LEFT(6, "<왼쪽>\n"),
    MIDDLE(8, "<중앙>\n"),
    RIGHT(7, "<오른쪽>\n");

    private int capacity;
    private String position;

    private Table(int num, String position) {
        this.capacity = num;
        this.position = position;
    }

    public int capacity() {
        return this.capacity;
    }

    public String getPosition() {
        return this.position;
    }
}
