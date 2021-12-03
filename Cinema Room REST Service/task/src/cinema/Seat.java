package cinema;

public class Seat {
    private final int row;
    private final int column;
    private final int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = (row <= 4) ? 10 : 8;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getPrice() {
        return price;
    }
}
