package org.joao;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private Rectangle cursor;
    private Rectangle pos;
    private MyGrid grid;


    public Cursor(MyGrid grid){

        this.grid = grid;


        this.cursor = new Rectangle(grid.getPADDING(), grid.getPADDING(), grid.getCellSize(), grid.getCellSize());
        this.cursor.setColor(Color.CYAN);
        this.cursor.fill();

       // cursor.draw();

    }


    public void paint(){

        double a = getRow();
        double b = getCol();
        double c = getCellSize();
        double d = getCellSize();
        pos = new Rectangle(a, b, c, d);
        pos.fill();
        grid.paintedPos.add(pos);
        System.out.println(grid.paintedPos.size());

    }

    public void deleteAll(){
        for(Rectangle pos : grid.paintedPos){
            pos.delete();
            grid.paintedPos.remove(pos);

        }
    }


    public void cursorBlink() throws InterruptedException {
        while(true){
            cursor.setColor(Color.WHITE);
            cursor.fill();
            //Thread.sleep(100);
            cursor.setColor(Color.GREEN);
            cursor.fill();
        }
    }

    public void getCursorPos(){
        System.out.println("Cursor: " + cursor.toString());
        System.out.println("Grid: " + grid.actualGrid.toString());
    }

    public int getRow(){
        return cursor.getX();
    }

    public int getCol(){
        return cursor.getY();
    }

    public int getMaxWidth(){
        return grid.gridMaxWidth();
    }

    public int getMaxHeight(){
        return grid.gridMaxHeight();
    }

    public int getGridPadding(){
        return grid.getPADDING();
    }

    public int getCellSize(){
        return grid.getCellSize();
    }

    public void moveRight(){
        cursor.translate(grid.getCellSize(), 0);
        getCursorPos();
    }

    public void moveLeft(){
        cursor.translate(- grid.getCellSize(), 0);
        getCursorPos();
    }

    public void moveUp(){
        cursor.translate(0, - grid.getCellSize());
        getCursorPos();

    }

    public void moveDwn(){
        cursor.translate(0, grid.getCellSize());
        getCursorPos();
    }


}
