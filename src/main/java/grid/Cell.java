package grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class Cell extends Rectangle {

    public static final int PADDING = 30;

    public static final int CELL_SIZE = 30;

    private Map<Integer, Integer> cellId = new HashMap<>();

    private boolean isFilled = false;

    public Cell(){}

    public Cell(int x, int y, int width, int height, Integer row, Integer col) {

        super(x, y, width, height);
        cellId.put(row, col);

    }

    public int getPADDING() {
        return PADDING;
    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }

   public boolean getFilled(){
        return isFilled;
   }

   public void setFilled(boolean filled) {
        this.isFilled = filled;
   }

   public Map<Integer, Integer> getCellId() {
        return cellId;
   }

    @Override
    public String toString() {
        return "Cell{" +
                "cellId=" + cellId.toString() +
                ", isFilled=" + isFilled +
                '}';
    }
}

