package org.academiadecodigo.PaintDaWish;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class Handler implements KeyboardHandler {

    private Keyboard keyboard;
    private Selector selector;
    private GridPositions gridPositions;
    private boolean isSpacePressed;
    private BufferedWriter bufferedWriter2;

    public Handler(Selector selector, GridPositions gridPositions) throws IOException {

        keyboard = new Keyboard(this);
        this.selector = selector;
        this.gridPositions = gridPositions;
        isSpacePressed = false;
        reDo();
        createKeyboardEvents();


    }

    public void createKeyboardEvents() throws IOException {

        FileWriter fileWriter2 = new FileWriter("resources/sequence.txt");
        bufferedWriter2 = new BufferedWriter(fileWriter2);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUP = new KeyboardEvent();
        keyboardEventUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventUP.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(keyboardEventUP);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventSpaceRELEASED = new KeyboardEvent();
        keyboardEventSpaceRELEASED.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEventSpaceRELEASED.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpaceRELEASED);

        KeyboardEvent keyboardEventC = new KeyboardEvent();
        keyboardEventC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(keyboardEventC);

        KeyboardEvent keyboardEventEsc = new KeyboardEvent();
        keyboardEventEsc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventEsc.setKey(KeyboardEvent.KEY_ESC);
        keyboard.addEventListener(keyboardEventEsc);

        KeyboardEvent keyboardEventS = new KeyboardEvent();
        keyboardEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(keyboardEventS);

        KeyboardEvent keyboardEventL = new KeyboardEvent();
        keyboardEventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventL.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(keyboardEventL);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey())
        {

            case KeyboardEvent.KEY_RIGHT:

                selector.moveSelector(Directions.RIGHT);

                try {
                    bufferedWriter2.write("right ");
                    bufferedWriter2.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (isSpacePressed) {
                    selector.selectorPaint();
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                selector.moveSelector(Directions.LEFT);

                try {
                    bufferedWriter2.write("left ");
                    bufferedWriter2.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (isSpacePressed) {
                    selector.selectorPaint();
                }
                break;

            case KeyboardEvent.KEY_UP:
                selector.moveSelector(Directions.UP);

                try {
                    bufferedWriter2.write("up ");
                    bufferedWriter2.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (isSpacePressed) {
                    selector.selectorPaint();
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                selector.moveSelector(Directions.DOWN);

                try {
                    bufferedWriter2.write("down ");
                    bufferedWriter2.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (isSpacePressed) {
                    selector.selectorPaint();
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                try {
                    bufferedWriter2.write("space ");
                    bufferedWriter2.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                selector.selectorPaint();
                isSpacePressed = true;
                break;

            case KeyboardEvent.KEY_C:

                gridPositions.clear();
                break;

            case KeyboardEvent.KEY_S:


                try {
                    gridPositions.save();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_L:


                try {
                    gridPositions.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case KeyboardEvent.KEY_ESC:
                System.exit(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        isSpacePressed = false;
    }

    //redo everything Selector did
    public void reDo() throws IOException {

        FileReader fileReader2 = new FileReader("resources/sequence.txt");
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        String line = "";
        String[] words;
        line = bufferedReader2.readLine();

        if (line != null) {
            words = line.split(" ");


            for (String word : words) {
                System.out.println(word);

                if (word.equals("up")) {

                    selector.moveSelector(Directions.UP);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else if (word.equals("down")) {
                    System.out.println("entrei no outro");
                    selector.moveSelector(Directions.DOWN);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else if (word.equals("left")) {
                    selector.moveSelector(Directions.LEFT);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else if (word.equals("right")) {
                    selector.moveSelector(Directions.RIGHT);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else if (word.equals("space")) {
                    selector.selectorPaint();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }


    }
}
