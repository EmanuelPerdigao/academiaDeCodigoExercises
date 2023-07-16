package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {

    private static int counter;


    public static  Car getNewCar() {

        Position position = new Position();
        CarType[] carTypeArray = CarType.values();

        switch (carTypeArray[(int)(Math.random() * 2)])
        {
            case FIAT:
                Fiat fiat = new Fiat(position, 1);
                return fiat;

            case MUSTANG :
                Mustang mustang = new Mustang(position, 2);
                return mustang;
        }
            return null;

    }
}
