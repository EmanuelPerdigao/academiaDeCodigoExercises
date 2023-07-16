package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private boolean isCrashed;
    private int speed;

    public Car (Position pos, int speed)
    {
        this.pos = pos;
        isCrashed = false;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return isCrashed;
    }

    public void setCrashed(boolean crashed) {
        isCrashed = crashed;
    }

}
