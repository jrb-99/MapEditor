package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor extends Cell implements KeyboardHandler, Controllable {

    private static Cursor instance;

    private static final int CURSOR_ID = 99;

    private Keyboard keyboard;

    private Cursor() {

        super(PADDING, PADDING, CELL_SIZE, CELL_SIZE, CURSOR_ID, CURSOR_ID);
        keyboard = new Keyboard(this);
        createKeyboardEvents();

    }

    public static Cursor getInstance() {

        if(instance == null) {

            instance = new Cursor();
            instance.setColor(Color.CYAN);
            instance.fill();
            instance.setFilled(true);

        }

        return instance;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_D:

                moveRight();
                break;
            case KeyboardEvent.KEY_A:

                moveLeft();
                break;
            case KeyboardEvent.KEY_S:

                moveDown();
                break;
            case KeyboardEvent.KEY_W:

                moveUp();
                break;
            case KeyboardEvent.KEY_SPACE:

                paintCell();
                break;
            case KeyboardEvent.KEY_E:

                erase();
                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

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
    public void moveUp() {
        instance.translate(0, -CELL_SIZE);

    }

    @Override
    public void moveDown() {
        instance.translate(0, CELL_SIZE);

    }

    @Override
    public void moveLeft() {
        instance.translate(-CELL_SIZE, 0);

    }

    @Override
    public void moveRight() {
        instance.translate(CELL_SIZE, 0);

    }

    @Override
    public void paintCell() {

    }

    @Override
    public void erase() {

    }
}
