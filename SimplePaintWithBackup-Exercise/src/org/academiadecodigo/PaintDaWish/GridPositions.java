package org.academiadecodigo.PaintDaWish;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.Arrays;

public class GridPositions {

    private Rectangle gridPositionsRectanglesArray[][];
    private int gridPositionsBinaryArray[][];
    private int cellSize;
    private int padding;
    private Rectangle rectanglePosition;
    private int maxHeigh;
    private int maxWidth;

    public GridPositions()
    {
        maxHeigh = 30;
        maxWidth = 30;
        cellSize = 20;
        padding = 10;
        gridPositionsRectanglesArray = new Rectangle[30][30];
        gridPositionsBinaryArray = new int[30][30];
        makeGridPositions();

    }

    public int getCellSize() {
        return cellSize;
    }

    public int getPadding() {
        return padding;
    }

    public int getMaxHeigh() {
        return maxHeigh;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void makeGridPositions()
    {
        //make every white square
        for (int x = 0; x < 30; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                //creating a new rectangle
                rectanglePosition = new Rectangle((x * cellSize) + padding,(y * cellSize) + padding, cellSize, cellSize);

                //store it inside the gridPositionsRectanglesArray
                gridPositionsRectanglesArray[x][y] = rectanglePosition;

                //store 0 (not painted) inside the gridPositionsBinaryArray
                gridPositionsBinaryArray[x][y] = 0;

                //draw the rectangle
                rectanglePosition.draw();
            }
        }
    }

    public void paint(int currentX, int currentY)
    {
        //if the square hasn't been painted
        if (gridPositionsBinaryArray[currentX][currentY] == 0)
        {
            gridPositionsRectanglesArray[currentX][currentY].setColor(Color.BLACK);
            gridPositionsRectanglesArray[currentX][currentY].fill();
            gridPositionsBinaryArray[currentX][currentY] = 1;
        }
        //if position has already been painted
        else
        {
            gridPositionsRectanglesArray[currentX][currentY].draw();
            gridPositionsBinaryArray[currentX][currentY] = 0;
        }
    }

    public void clear()
    {
            for (int x = 0; x < 30; x++)
            {
                for (int y = 0; y < 30; y++)
                {
                    //if C has been pressed, clear everything
                    gridPositionsRectanglesArray[x][y].draw();
                    gridPositionsBinaryArray[x][y] = 0;
                }
            }
    }

    public void save() throws IOException {

            //create a fileWriter to save the positions that are painted
            FileWriter fileWriter = new FileWriter("resources/positions.txt");

            //create a bufferedWriter to write to the file in bytes
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            for (int x = 0; x < 30; x++)
            {
                for (int y = 0; y < 30; y++)
                {
                    //read the binary array to know witch positions have been painted
                    int painted = gridPositionsBinaryArray[x][y];

                    //if the position has been painted
                    if(painted == 1)
                    {
                        //write 1 to file
                        bufferedWriter.write("1");

                    }
                    else
                    {
                        //write 0 to file
                        bufferedWriter.write("0");
                    }
                    //is the last square position
                    if (y == 29)
                    {
                        //add a new line (\n)
                        bufferedWriter.newLine();
                    }
                }
            }
            //close streams
            bufferedWriter.close();
            fileWriter.close();

    }

    public void load() throws IOException {

        //create a fileReader to read the positions file
        FileReader fileReader = new FileReader("resources/positions.txt");

        for (int x = 0; x < 30; x++)
        {
            for (int y = 0; y < 30; y++)
            {
                //read the file to know which positions have been painted and store it in num
                int num = fileReader.read();

                //if the position has been painted
                if ((char) num == '1')
                {
                    //paint position
                    gridPositionsBinaryArray[x][y] = 1;
                    gridPositionsRectanglesArray[x][y].fill();
                }
                //if the position hasn't been painted
                else if ((char) num == '0')
                {
                    //write in the array the position that hasn't been painted
                    gridPositionsBinaryArray[x][y] = 0;

                }
                else
                {
                    //if the byte is a (\n) new line decrement the y to run every position of the file
                    y--;
                }
            }
        }
       //close stream
        fileReader.close();
    }
}
