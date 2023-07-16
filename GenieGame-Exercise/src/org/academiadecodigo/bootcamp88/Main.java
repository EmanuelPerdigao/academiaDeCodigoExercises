package org.academiadecodigo.bootcamp88;

public class Main {

    public static void main(String[] args) {

        //Create an instance of the Genie class
        Genie genie = new Genie(20);

        //create an instance of the MagicLamp class
        MagicLamp magicLamp = new MagicLamp(4);


        //game logic
        magicLamp.rubbed();
        magicLamp.makeWishes(0);
        magicLamp.makeWishes(0);
        magicLamp.makeWishes(0);
        magicLamp.rubbed();
        magicLamp.makeWishes(1);
        magicLamp.makeWishes(1);
        magicLamp.makeWishes(1);
        magicLamp.makeWishes(1);
        magicLamp.makeWishes(1);
        magicLamp.rubbed();
        magicLamp.rubbed();
        magicLamp.rubbed();
    }

}
