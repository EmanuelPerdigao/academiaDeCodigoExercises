package org.academiadecodigo.IntegerRangeLoopList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        IntegerRange integerRange = new IntegerRange(-10,10);
        Iterator myIterator = integerRange.iterator();

        while (myIterator.hasNext())
        {
            System.out.println(myIterator.next());
        }


    }
}
