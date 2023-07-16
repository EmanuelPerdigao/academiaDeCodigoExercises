package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.cars.MoveDirections;

public class Position {

    private int maxCol;     // MAX Columns
    private int maxRow;    // MAX Rows
    private int currentCol;
    private int currentRow;
    private int stepsCounter;
    private boolean isAbigStep;
    private MoveDirections lastMoveDirection;

    public Position ()
    {
        this.maxCol = Field.getWidth();
        this.maxRow = Field.getHeight();
        this.currentCol = (int) (Math.random() * maxCol);
        this.currentRow = (int) (Math.random() * maxRow);
        this.stepsCounter = 0;
        this.isAbigStep = false;
    }

    public int getCol()
    {
        return currentCol;
    }

    public int getRow()
    {
        return currentRow;
    }

    public void setCurrentCol(int currentCol)
    {
        this.currentCol = currentCol;
    }

    public void setCurrentRow(int currentRow)
    {
        this.currentRow = currentRow;
    }

    public int getMaxCol()
    {
        return maxCol;
    }

    public int getMaxRow()
    {
        return maxRow;
    }

    public int getStepsCounter()
    {
        return stepsCounter;
    }

    public void setStepsCounter(int stepsCounter)
    {
        this.stepsCounter = stepsCounter;
    }

    public boolean isAbigStep()
    {
        return isAbigStep;
    }

    public void setAbigStep(boolean abigStep)
    {
        isAbigStep = abigStep;
    }

    public MoveDirections getLastMoveDirection()
    {
        return lastMoveDirection;
    }

    public void setLastMoveDirection(MoveDirections lastMoveDirection)
    {
        this.lastMoveDirection = lastMoveDirection;
    }

}
