package org.academiadecodigo.bootcamp88;

public class Hotel {

    private String hotelName;
    private int maxRooms;
    private Room[] roomArray;



    public Hotel (int maxRooms, String hotelName)
    {
        this.maxRooms = maxRooms;
        this.hotelName = hotelName;
        roomArray = new Room[maxRooms];
        createRooms(maxRooms);
    }

    private void createRooms(int maxRooms)
    {
        for (int i = 0; i < maxRooms; i++)
        {
            roomArray[i] = null;
        }
    }

    public int reserve(Person person)
    {

        for (int i = 0;i < maxRooms; i++)
        {
            if (roomArray[i] == null)
            {
                roomArray[i] = new Room(i);
                System.out.println(person.getPersonName() + " your reserve is confirmed!");
                return i;
            }
        }
        System.out.println(person.getPersonName() + " your reserve is NOT confirmed!");
        return -1;
    }

    public boolean checkin(Person person, int roomNumber)
    {
        for (int i = 0;i < maxRooms; i++)
        {
            if(roomArray[i].getRoomNumber() == roomNumber)
            {
                System.out.println(person.getPersonName() + " did the checkin, his room number is: " + i);
                roomArray[i].setPerson(person);
                return true;
            }

        }
        System.out.println("The" + person.getPersonName() + "is not foud in our system");
        return false;

    }

    public  boolean checkout(Person personName,int roomNumber)
    {
        for (int i = 0;i < maxRooms; i++)
        {
            if(roomArray[i].getRoomNumber() == i)
            {
                roomArray[i].removePerson();
                roomArray[i] = null;
                System.out.println(personName.getPersonName() + " Your checkout is done!!!");
                return true;

            }
        }

        System.out.println("The" + personName.getPersonName() + "is not on this room number: "+ roomNumber);
        return false;
    }

}
