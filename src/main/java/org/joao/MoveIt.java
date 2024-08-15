package org.joao;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MoveIt implements KeyboardHandler {

    private Cursor cursor;

    private Keyboard keyboard;

    public MoveIt(Cursor rectangle){

        this.cursor = rectangle;
        keyboard = new Keyboard(this);
        createKeyboardEvents();

    }

    public void createKeyboardEvents(){
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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_D:
                if(cursor.getRow() == cursor.getMaxWidth() - (cursor.getGridPadding() * 2)){
                    System.out.println(cursor.getMaxWidth());
                    return;
                }
                cursor.moveRight();
                break;
            case KeyboardEvent.KEY_A:
                if(cursor.getRow() == cursor.getGridPadding()){
                    System.out.println(cursor.getRow() + " / " + cursor.getGridPadding());
                    return;
                }
                cursor.moveLeft();
                break;
            case KeyboardEvent.KEY_S:
                if(cursor.getCol() == cursor.getMaxHeight() - (cursor.getGridPadding() * 2)){
                    return;
                }
                cursor.moveDwn();
                break;
            case KeyboardEvent.KEY_W:
                if(cursor.getCol() == cursor.getGridPadding()){
                    System.out.println(cursor.getCol() + " / " + cursor.getGridPadding());
                    return;
                }
                cursor.moveUp();
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.paint();

                break;
            case KeyboardEvent.KEY_E:
                cursor.deleteAll();
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
