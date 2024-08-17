package grid;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid implements KeyboardHandler {

    private Cell[][] cellArr;

    private final Cursor cursor;

    private final Keyboard keyboard;

    private int rows;

    private int cols;

    public Grid(int rows, int cols, Cursor cursor){

        this.rows = rows;
        this.cols = cols;
        this.cursor = cursor;
        this.cellArr = new Cell[rows][cols];
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void addCell(int row, int col, Cell cell){

        cellArr[row][col] = cell;

    }

    public Cursor getCursor(){
        return this.cursor;
    }

    private int getRows(){
        return this.rows;
    }

    private int getCols(){
        return this.cols;
    }

    //Cursor movement ***********************************

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_D:

                cursor.moveRight();
                break;
            case KeyboardEvent.KEY_A:

                cursor.moveLeft();
                break;
            case KeyboardEvent.KEY_S:

                cursor.moveDown();
                break;
            case KeyboardEvent.KEY_W:

                cursor.moveUp();
                break;
            case KeyboardEvent.KEY_SPACE:

                cursor.paintCell();
                break;
            case KeyboardEvent.KEY_E:

                cursor.erase();
                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void createKeyboardEvents(){
        //Right

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_D);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        //Left

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_A);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        //Up

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_W);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        //Down

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_S);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        //Paint (Space)

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        //Delete (E)

        KeyboardEvent keyboardEventDelete = new KeyboardEvent();
        keyboardEventDelete.setKey(KeyboardEvent.KEY_E);
        keyboardEventDelete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDelete);

    }

    //****************************************************

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
