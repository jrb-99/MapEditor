package factories;

import grid.Cell;
import grid.Cursor;
import grid.Grid;

public class GridBuilder implements Builder{

    private Grid grid;

    @Override
    public Cell buildCell(int i, int j) {
        return new Cell(Cell.PADDING * j, Cell.PADDING * i , Cell.CELL_SIZE, Cell.CELL_SIZE, i, j);
    }

    @Override
    public Cursor buildCursor(int rows, int cols) {

        return Cursor.getInstance(rows, cols);
    }

    @Override
    public Grid buildGrid(int rows, int cols) {

        Cursor cursor = buildCursor(rows, cols);
        grid = new Grid(rows, cols, cursor);

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                Cell cell = buildCell(i, j);
                System.out.println("i row: " + i + " j col: " + j);
                System.out.println(cell.getCellId().toString());
                grid.addCell(i, j, cell);
                cell.draw();
            }
        }
        return grid;
    }
}
