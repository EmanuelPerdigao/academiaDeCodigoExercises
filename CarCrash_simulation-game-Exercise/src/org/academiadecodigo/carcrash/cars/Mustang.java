package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car{

    public int speed = 2;

    public Mustang(Position pos, int speed) {
        super(pos, speed);
    }

    @Override
    public String toString() {
        if(!isCrashed())
        {
            return "M";
        }
        else
        {
            return "C";
        }
    }
}
