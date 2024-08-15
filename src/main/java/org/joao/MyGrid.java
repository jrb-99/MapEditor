package org.joao;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.*;


public class MyGrid{

    Map<Integer, Integer> posMap = new HashMap<>();
    List<Rectangle> paintedPos = new LinkedList<>();
    Rectangle actualGrid;
    Rectangle pos;
    Cursor cursor;
    private int row;
    private int col;
    private final int PADDING = 10;
    private final int CELL_SIZE = 30;

    public MyGrid(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void gridInit() {
        //Rectangle rectangle = new Rectangle(PADDING, PADDING, CELL_SIZE, CELL_SIZE);
        //rectangle.draw();

        //Rectangle rectangle1 = new Rectangle(PADDING + CELL_SIZE, PADDING, CELL_SIZE, CELL_SIZE);
        //rectangle1.draw();

        for (int i = 1; i <= getRow(); i++) {
            //Rectangle row = new Rectangle(PADDING + (CELL_SIZE * i), PADDING, CELL_SIZE, CELL_SIZE);
            for (int j = 1; j <= getCol(); j++) {
                //actualGrid = new Rectangle(PADDING + (CELL_SIZE * i), PADDING + (CELL_SIZE * j), CELL_SIZE, CELL_SIZE);
                System.out.println("Rows add: " + ((CELL_SIZE * i) - (2 * PADDING)));
                System.out.println("Cols add: " + ((CELL_SIZE * j) - (2 * PADDING)));
                int key = ((CELL_SIZE * i) - (2 * PADDING));
                int value = ((CELL_SIZE * j) - (2 * PADDING));
                posMap.put(((CELL_SIZE * i) - (2 * PADDING)), ((CELL_SIZE * j) - (2 * PADDING)));
                actualGrid = new Rectangle(PADDING, PADDING, (CELL_SIZE * i), (CELL_SIZE * j));
                actualGrid.draw();
                //row.draw();
                System.out.println("i: " + i + ", j: " + j);

            }
        }
    }


    /*public void paint(){

        double a = cursor.getRow();
        double b = cursor.getCol();
        double c = CELL_SIZE;
        double d = CELL_SIZE;
        pos = new Rectangle(a, b, c, d);
        pos.fill();
        paintedPos.add(pos);
        System.out.println(paintedPos.size());

    }
     */

    public void delete(){
        for(Rectangle pos : paintedPos){
            pos.delete();
            paintedPos.remove(pos);
        }
    }

    public void getInfo(){
        System.out.println(posMap.isEmpty());
        System.out.println(posMap.size());
        Set<Integer> set = posMap.keySet();
        Collection<Integer> list = posMap.values();
        System.out.println(set + " | " + list);


    }

    public int getCellSize() {
        return CELL_SIZE;
    }
    public int getPADDING() {
        return PADDING;
    }
    public int getCol() {
        return this.col;
    }
    public int getRow() {
        return this.row;
    }
    public int gridMaxWidth() {
        return actualGrid.getWidth();
    }
    public int gridMaxHeight() {
        return actualGrid.getHeight();
    }

    public String test(){
        return actualGrid.toString();
    }

}
