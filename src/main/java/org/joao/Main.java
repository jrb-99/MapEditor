package org.joao;

import org.joao.MoveIt;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyGrid grid = new MyGrid(20, 20);
        Cursor cursor = new Cursor(grid);
        grid.gridInit();
        grid.getInfo();
        new MoveIt(cursor);
        //cursor.cursorBlink();

    }
}
