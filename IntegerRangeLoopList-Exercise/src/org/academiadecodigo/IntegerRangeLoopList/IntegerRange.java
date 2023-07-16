package org.academiadecodigo.IntegerRangeLoopList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class IntegerRange implements Iterable{

    private MyIterator myIterator;
    private int minValue;
    private int maxValue;

    public IntegerRange(int minValue, int maxValue)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator
    {
        int counter = minValue;

        @Override
        public boolean hasNext() {

            return counter <= maxValue;
        }

        @Override
        public Object next() {

            if (counter  <= maxValue )
            {
                return counter++;
            }
            else
            {
                throw new NumberFormatException();
            }
        }

    }
}
