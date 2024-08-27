package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;
import java.util.Map;
import static grid.Cell.CELL_SIZE;
import static grid.Cell.PADDING;

public class Cursor extends Rectangle implements Controllable {

    private static Cursor instance;

    private Map<Integer, Integer> position = new HashMap<>();

    private boolean isFilled = false;

    private int max_rows;

    private int max_cols;

    private Cursor() {

        super(PADDING, PADDING, CELL_SIZE, CELL_SIZE);
        position.put(1, 1);

    }

    public static Cursor getInstance(int max_rows, int max_cols) {

        if(instance == null) {

            instance = new Cursor();
            instance.setColor(Color.CYAN);
            instance.fill();
            instance.setFilled(true);
            instance.setMax_rows(max_rows);
            instance.setMax_cols(max_cols);
            System.out.println("max rows: " + max_rows + " max cols: " + max_cols);

        }

        return instance;
    }

    private void setMax_rows(int max_rows) {
        this.max_rows = max_rows;
    }

    private void setMax_cols(int max_cols) {
        this.max_cols = max_cols;
    }

    private void setFilled(boolean filled) {
        this.isFilled = filled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    private void setPosition(int row, int col) {
        this.position.clear();
        this.position.put(row, col);
        //System.out.println("position(rows, cols): " + position.toString());
    }

    protected int getRowPos(){

        return position.keySet().toArray(new Integer[0])[0];
    }

    protected int getColPos(){

        return position.values().toArray(new Integer[0])[0];
    }

    public Map<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public void moveUp(Cell cell) {
        if(getRowPos() == 1) {
            return;
        }
        instance.translate(0, -CELL_SIZE);
        instance.setPosition(getRowPos()-1, getColPos());
        System.out.println("cell(row,col): " + cell.getCellId().toString() + " | " + "cursor(row.col): " + instance.position.toString());
        System.out.println("x: " + instance.getX() + "y: " + instance.getY());


    }

    @Override
    public void moveDown(Cell cell) {
        if(getRowPos() == this.max_rows) {
            return;
        }
        instance.translate(0, CELL_SIZE);
        instance.setPosition(getRowPos()+1, getColPos());
        System.out.println("cell(row,col): " + cell.getCellId().toString() + " | " + "cursor(row.col): " + instance.position.toString());
        System.out.println("x: " + instance.getX() + "y: " + instance.getY());



    }

    @Override
    public void moveLeft(Cell cell) {
        if(getColPos() == 1) {
            return;
        }
        instance.translate(-CELL_SIZE, 0);
        instance.setPosition(getRowPos(), getColPos()-1);
        System.out.println("cell(row,col): " + cell.getCellId().toString() + " | " + "cursor(row.col): " + instance.position.toString());
        System.out.println("x: " + instance.getX() + "y: " + instance.getY());

    }

    @Override
    public void moveRight(Cell cell) {
        if(getColPos() == this.max_cols) {
            return;
        }
        instance.translate(CELL_SIZE, 0);
        instance.setPosition(getRowPos(), getColPos()+1);
        System.out.println("cell(row,col): " + cell.getCellId().toString() + " | " + "cursor(row.col): " + instance.position.toString());
        System.out.println("x: " + instance.getX() + "y: " + instance.getY());


    }

    @Override
    public void paintCell(Cell cell) {
        if(cell.getFilled()){
            System.out.println("Cell is filled");
            return;
        }

        cell.setColor(Color.BLACK);
        cell.fill();
        cell.setFilled(true);


    }

    @Override
    public void erase(Cell cell) {
        if(cell.getFilled()) {

            cell.delete();
            cell.draw();
            cell.setFilled(false);
        }

    }
}
