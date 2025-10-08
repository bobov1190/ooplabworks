public class Column {

    private int column, cans;
    private String beverageName;

    public Column(int column, String beverageName, int cans) {
        this.column = column;
        this.cans = cans;
        this.beverageName = beverageName;
    }

    public int getCans() {
        return cans;
    }

    public int getColumn() {
        return column;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void Decrease() {
        cans--;
    }
}
