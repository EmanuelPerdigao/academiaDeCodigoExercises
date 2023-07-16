package org.academiadecodigo.bootcamp88;

public class MagicLamp {

    private int maxGenies;
    private Genie[] genies;
    private int rubbedCounter;
    private int geniesCounter;
    private int maxGeniesWithDemon;

    //construtor
    public MagicLamp(int maxGenies) {

        this.maxGenies = maxGenies;
        maxGeniesWithDemon = maxGenies + 1;
        genies = new Genie[maxGeniesWithDemon];
        rubbedCounter = 1;
        geniesCounter = 0;
    }

    //rubbed the lamp method to create a genie or a recyclable demon
    public void rubbed()
    {

        //if the genie is the last one a recyclable demon
        if (rubbedCounter == (maxGeniesWithDemon - 1)) {
            //print the genie who was created is a recyclable demon
            System.out.println("I created a recyclable Demon!");

            //create the recyclable demon and add it to the array of genies
            genies[rubbedCounter - 1] = new RecyclableDemon(10);

            //increment the genie counter and rubbed counter
            geniesCounter++;
            rubbedCounter++;
        }
        //if the lamp has reached the max number of genies
        else if (rubbedCounter == maxGeniesWithDemon) {

            //if the genie is a recyclable demon
            if (genies[maxGeniesWithDemon - 1] instanceof RecyclableDemon)
            {
                //cast to the subclass (recyclable demon)
                ((RecyclableDemon) genies[maxGeniesWithDemon]).setRecycled(true);
            }

            //reset the lamp (recycle)
            System.out.println("I recycle everything and create a Grumpy");

            //reset the rubbed counter
            rubbedCounter = 1;

            //create a new GrumpyGenie and add it to the array of genies
            genies[rubbedCounter - 1] = new GrumpyGenie(3);
            rubbedCounter++;
            geniesCounter++;
        }

        //if the rubbed counter is odd
        else if (rubbedCounter % 2 == 0) {

            //print the genie created is a Friendly Genie
            System.out.println("I created a Friendly Genie!");

            //create a FriendlyGenie and add it to the array of genies
            genies[rubbedCounter - 1] = new FriendlyGenie(3);
            rubbedCounter++;

        }

        //if the rubbed counter is even
        else {

            //print the genie created is a Grumpy Genie
            System.out.println("I created a Grumpy Genie!");

            //create a GrumpyGenie and add it to the array of genies
            genies[rubbedCounter - 1] = new GrumpyGenie(3);
            rubbedCounter++;
        }

    }

    public void makeWishes(int genie)
    {
        //call the specific genie method to make wishes
        genies[genie].makeWishes();

    }
}