package org.academiadecodigo.PaintDaWish;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

         new Grid();
        GridPositions gridPositions = new GridPositions();
        Selector selector = new Selector(gridPositions);
        new Handler(selector, gridPositions);

    }
}
