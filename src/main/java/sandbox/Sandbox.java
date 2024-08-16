package sandbox;

import factories.GridBuilder;
import grid.Grid;

public class Sandbox {
    public static void main(String[] args) throws InterruptedException {

        GridBuilder builder = new GridBuilder();
        Grid grid = builder.buildGrid(20, 20);

        grid.printGrid();







    }
}
