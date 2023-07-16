package org.academiadecodigo.bootcamp88;

public class Genie {

    private int maxWishes;
    private int whishesCounter;
    private String className = this.getClass().getSimpleName();

    //Contructor
    public Genie(int maxWishes)
    {
        this.maxWishes = maxWishes;
        this.whishesCounter = 0;
    }

    //Setter to set the max wishes
    public void setMaxWishes(int maxWishes) {
        this.maxWishes = maxWishes;
    }

    //method to make wishes
    public void makeWishes()
    {

        //if the genie has reached the max wishes
        if (whishesCounter == maxWishes)
        {
            //print he cant make wishes
            System.out.println("SRY! i " + className + " have made all wishes i could do");
            return;
        }

        //if the genie doesn't reach the max wishes
        if(whishesCounter < maxWishes)
        {
            //print the genie have made a wish
            System.out.println("I " + className + " have made a wish");

            //Increment the wish counter
            whishesCounter++;
        }

    }

}
