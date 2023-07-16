package org.academiadecodigo.bootcamp88;

public class Room {

    private Person person = null;
    private int roomNumber;
    private boolean roomAvailable = true;


    public Room(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public Person getPerson()
    {
        return this.person;
    }


    public void setPerson(Person person)
    {
        this.person = person;
    }

    public boolean getroomAvailable()
    {

        return this.roomAvailable;
    }

    public void setRoomAvailable(boolean roomAvailable){

        this.roomAvailable = roomAvailable;

    }

    public int getRoomNumber()
    {

       return  this.roomNumber;

    }
    public void removePerson()
    {
        this.person = null;
    }


}
