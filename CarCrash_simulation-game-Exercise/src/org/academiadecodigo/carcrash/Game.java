package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.cars.MoveDirections;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private final int delay;

    private final MoveDirections[] moveDirections = MoveDirections.values();
    private boolean positionChoosed = false;
    private int currentCol;
    private int currentRow;
    private MoveDirections nextMoveDirection;

    public Game(int cols, int rows, int delay)
    {
        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++)
        {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException
    {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars);

        }
    }

    private void moveAllCars() {

        //loop to all the cars
        for (int i = 0; i < cars.length; i++)
        {

            //if the position isnt choosed yet
            positionChoosed = false;

            //if the car didnt crashed yet
            if (!cars[i].isCrashed())
            {

                //while the position isnt chose
                while (!positionChoosed)
                {

                    //check if is a big or small step and define the next move (lastMoveDirecion) to the next move direction
                    checkIfIsABigOrSmallStep(i);

                    //if the direction is to move up
                    if (cars[i].getPos().getLastMoveDirection() == MoveDirections.moveUp)
                    {

                        //get the current row
                        currentRow = cars[i].getPos().getRow();

                        for (int z = 0; z < cars[i].getSpeed(); z++) {

                            //if the next row move is higher then 0
                            if ((currentRow - 1) > 0) {

                                currentRow -= 1;
                                cars[i].getPos().setCurrentRow(currentRow);
                                positionChoosed = true;

                                //Check if theres colision
                                if(checkIfTheresCrashes(i)) {
                                    break;
                                }

                            }
                            else
                            {
                                //if is a big step and the limit has reached
                                if (cars[i].getPos().isAbigStep())
                                {
                                    cars[i].getPos().setStepsCounter(5);
                                    positionChoosed = true;
                                }
                            }

                        }
                    }

                    //if the direction is to move down
                    if (cars[i].getPos().getLastMoveDirection() == MoveDirections.moveDown)
                    {

                        //get the current row
                        currentRow = cars[i].getPos().getRow();

                        for (int z = 0; z < cars[i].getSpeed(); z++) {

                            //if the next row move is lower then the max row possible
                            if ((currentRow + 1) < cars[i].getPos().getMaxRow()) {

                                currentRow += 1;
                                cars[i].getPos().setCurrentRow(currentRow);
                                positionChoosed = true;

                                //Check if theres colision
                                if(checkIfTheresCrashes(i)) {
                                    break;
                                }

                            } else {
                                //if is a big step and the limit has reached
                                if (cars[i].getPos().isAbigStep()) {
                                    cars[i].getPos().setStepsCounter(5);
                                    positionChoosed = true;
                                }
                            }
                        }
                    }

                    //if the direction is to move left
                    if (cars[i].getPos().getLastMoveDirection() == MoveDirections.moveLeft)
                    {

                        //get the current col
                        currentCol = cars[i].getPos().getCol();

                        for (int z = 0; z < cars[i].getSpeed(); z++) {

                            //if the next col move is higher then 0
                            if ((currentCol - 1) > 0) {

                                currentCol -= 1;
                                cars[i].getPos().setCurrentCol(currentCol);
                                positionChoosed = true;

                                //Check if theres colision
                                if(checkIfTheresCrashes(i)) {
                                    break;
                                }

                            }
                            else {
                                //if is a big step and the limit has reached
                                if (cars[i].getPos().isAbigStep()) {
                                    cars[i].getPos().setStepsCounter(5);
                                    positionChoosed = true;
                                }
                            }
                        }
                    }

                    //if the direction is to move right
                    if (cars[i].getPos().getLastMoveDirection() == MoveDirections.moveRight)
                    {

                        //get the current col
                        currentCol = cars[i].getPos().getCol();

                        for (int z = 0; z < cars[i].getSpeed(); z++) {

                            //if the next row move is lower then the max row possible
                            if ((currentCol + 1) < cars[i].getPos().getMaxCol()) {

                                currentCol += 1;
                                cars[i].getPos().setCurrentCol(currentCol);
                                positionChoosed = true;

                                //Check if theres colision
                                if(checkIfTheresCrashes(i)) {
                                    break;
                                }

                            }
                            else {
                                //if is a big step and the limit has reached
                                if (cars[i].getPos().isAbigStep())
                                {
                                    cars[i].getPos().setStepsCounter(5);
                                    positionChoosed = true;
                                }
                            }
                        }
                    }
                }
            }

            changeToAnotherStep(i);

        }
    }




    public void checkIfIsABigOrSmallStep(int i)
    {
        //Check if is a small step
        if (!cars[i].getPos().isAbigStep())
        {

            nextMoveDirection = moveDirections[(int) (Math.random() * 4)];
            cars[i].getPos().setLastMoveDirection(nextMoveDirection);

        }
        else
        {

            if(cars[i].getPos().getStepsCounter() == 0)
            {
                nextMoveDirection = moveDirections[(int) (Math.random() * 4)];
                cars[i].getPos().setLastMoveDirection(nextMoveDirection);
            }
            cars[i].getPos().setStepsCounter((cars[i].getPos().getStepsCounter()) + 1);

        }
    }





    public void changeToAnotherStep(int i)
    {
        //=============================================  Big Step and small Step system

        if (cars[i].getPos().getStepsCounter() == 5)
        {
            cars[i].getPos().setAbigStep(false);
            cars[i].getPos().setStepsCounter(0);

        }
        else if (cars[i].getPos().getStepsCounter() == 0)
        {
            cars[i].getPos().setAbigStep(true);
        }
    }





    public boolean checkIfTheresCrashes(int carPositionInArray)
    {

        //=============================================  Check if theres crashes

        for (int z = 0; z < cars.length; z++)
        {
            //if the car moved before is in the same position of another
            if (cars[carPositionInArray].getPos().getCol() == cars[z].getPos().getCol() && cars[carPositionInArray].getPos().getRow() == cars[z].getPos().getRow())
            {
                //If is not the same car
                if (cars[carPositionInArray] != cars[z])
                {

                    //set the cars crashed
                    cars[carPositionInArray].setCrashed(true);
                    cars[z].setCrashed(true);
                    return true;

                }
            }
        }
        return false;
    }


}

