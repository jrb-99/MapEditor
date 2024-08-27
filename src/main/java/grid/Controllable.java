package grid;

public interface Controllable {

    void moveUp(Cell cell);

    void moveDown(Cell cell);

    void moveLeft(Cell cell);

    void moveRight(Cell cell);

    void paintCell(Cell cell);

    void erase(Cell cell);

}
