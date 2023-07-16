package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car{


    public Fiat(Position pos, int speed)
    {
        super(pos, speed);

    }

    @Override
    public String toString()
    {
        if(!isCrashed())
        {
            return "F";
        }
        else
        {
            return "C";
        }
    }
}
