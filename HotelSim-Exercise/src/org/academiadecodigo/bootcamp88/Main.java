package org.academiadecodigo.bootcamp88;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(20, "Tivoli");
        Person person1 = new Person("Rui", hotel);

        person1.doSomething(person1);

    }

}
