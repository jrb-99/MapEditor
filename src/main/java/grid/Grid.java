package grid;

public class Grid {

    private Cell[][] cellArr;

    private Cursor cursor;

    public Grid(int rows, int cols, Cursor cursor){

        this.cursor = cursor;
        this.cellArr = new Cell[rows][cols];
    }

    public void addCell(int row, int col, Cell cell){

        cellArr[row][col] = cell;

    }

    public void printGrid(){

        for(int i = 0; i < cellArr.length; i++){
            System.out.println("| ");
            for(int j = 0; j < cellArr[i].length; j++){
                System.out.println(cellArr[i][j].getCellId().toString() + " | ");
            }
            //print new line
            System.out.println();
        }

    }

}
