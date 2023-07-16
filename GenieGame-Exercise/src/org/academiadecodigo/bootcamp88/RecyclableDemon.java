package org.academiadecodigo.bootcamp88;

public class RecyclableDemon extends Genie{

boolean isRecycled;
private String className = this.getClass().getSimpleName();

    //Contrutor
    public RecyclableDemon(int maxWishes) {
        super(maxWishes);
        this.isRecycled = false;
    }

    //setter
    public void setRecycled(boolean recycled)
    {
        isRecycled = recycled;
    }


    @Override
    public void makeWishes()
    {

        //if the recyclable demon is not recycled
        if (!isRecycled)
        {
            //print he has made a wish
            System.out.println("I " + className + " have made a wish");
        }

    }
}
