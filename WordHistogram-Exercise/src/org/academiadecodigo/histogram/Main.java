package org.academiadecodigo.histogram;

public class Main {

    public static final String STRING = "teste teste teste one one one alo";

    public static void main(String[] args) {

        WordHistogram wordHistogram = new WordHistogram(STRING);
        System.out.println("Map has " + wordHistogram.size() + " distinct words");

        for (String word : wordHistogram)
        {
            System.out.println(word + " : " + wordHistogram.get(word));
        }
    }

}
