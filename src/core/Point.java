package core;

/**
 * A product of mecha
 */
public class Point {
    int row, column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Point() {
        row = -1;
        column = -1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int newRow) {
        row = newRow;
    }

    public void setColumn(int newColumn) {
        column = newColumn;
    }
}
