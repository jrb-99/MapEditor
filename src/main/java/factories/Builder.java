package factories;

import grid.Cell;
import grid.Cursor;
import grid.Grid;

public interface Builder {

    Cell buildCell(int i, int j);

    Cursor buildCursor();

    Grid buildGrid(int rows, int cols);
}
