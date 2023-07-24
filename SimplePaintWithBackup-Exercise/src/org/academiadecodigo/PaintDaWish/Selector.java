package org.academiadecodigo.PaintDaWish;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Selector {

    private int currentX;
    private int currentY;
    GridPositions gridPositions;
    Rectangle rectangleSelector;


    public Selector(GridPositions gridPositions)
    {

        this.currentX = 0;
        this.currentY = 0;
        this.gridPositions = gridPositions;
        rectangleSelector = new Rectangle((currentX * gridPositions.getCellSize()) + gridPositions.getPadding(),(currentY * gridPositions.getCellSize()) + gridPositions.getPadding(), gridPositions.getCellSize(), gridPositions.getCellSize());
        rectangleSelector.setColor(Color.BLUE);
        rectangleSelector.fill();
    }

    public void moveSelector(Directions direction)
    {

        switch (direction)
        {
            case UP:

                if(currentY > 0)
                {
                    currentY -= 1;
                    rectangleSelector.translate(0, - gridPositions.getCellSize());
                }

                break;

            case DOWN:

                if(currentY < gridPositions.getMaxHeigh() - 1)
                {
                    currentY += 1;
                    rectangleSelector.translate(0, gridPositions.getCellSize());
                }

                break;

            case LEFT:

                if (currentX > 0)
                {
                    currentX -= 1;
                    rectangleSelector.translate( - gridPositions.getCellSize(), 0);
                }

                break;

            case RIGHT:


                if (currentX < gridPositions.getMaxWidth() - 1)
                {
                    currentX += 1;
                    rectangleSelector.translate(gridPositions.getCellSize(), 0);
                }

                break;
        }


    }

    public void selectorPaint()
    {
       gridPositions.paint(currentX, currentY);
    }
}
