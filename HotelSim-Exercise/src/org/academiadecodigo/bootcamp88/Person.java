package org.academiadecodigo.bootcamp88;

public class Person {

    private String personName;
    private Hotel hotel;
    private Person person;
    private int roomNumber;


    public Person (String personName, Hotel hotel)
    {
        this.personName = personName;
        this.hotel = hotel;
    }

    public String getPersonName()
    {
        return this.personName;
    }

    public void doSomething(Person personRef)
    {
        this.person = personRef;
        roomNumber = hotel.reserve(person);
        hotel.checkin(person, roomNumber);
        hotel.checkout(person, roomNumber);

    }


}
